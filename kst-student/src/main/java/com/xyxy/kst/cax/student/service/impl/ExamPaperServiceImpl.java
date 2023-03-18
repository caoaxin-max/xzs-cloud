package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.*;
import com.xyxy.kst.cax.entity.Class;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.student.dao.ExamPaperAnswerDao;
import com.xyxy.kst.cax.student.dao.ExamPaperDao;
import com.xyxy.kst.cax.student.dao.SubjectDao;
import com.xyxy.kst.cax.student.service.ClassService;
import com.xyxy.kst.cax.student.service.ClassTeacherService;
import com.xyxy.kst.cax.student.service.ExamPaperService;
import com.xyxy.kst.cax.student.service.UserService;
import com.xyxy.kst.cax.utils.DateTimeUtil;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import com.xyxy.kst.cax.viewmodel.student.AnalyseFrom;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/7/19:15
 */
@Service
public class ExamPaperServiceImpl extends ServiceImpl<ExamPaperDao, ExamPaper> implements ExamPaperService {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ClassTeacherService classTeacherService;

    @Autowired
    private ExamPaperAnswerDao examPaperAnswerDao;

    @Autowired
    private SubjectDao subjectDao;

    /**
     * 查询固定试卷和时段试卷
     *
     * @return
     */
    @Override
    public Result selectExamPaper(Integer userId) {
        User user = userService.getById(userId);
        if (user.getClassId() != 0) {
            Map<String, Object> map = new HashMap<>();
            List<ExamPaper> fixedExamPaper = new ArrayList<>();
            List<ExamPaper> timeLimitPaper = new ArrayList<>();
            List<ClassTeacher> classTeachers = classTeacherService.getClassTeacher(user.getClassId());
            for (ClassTeacher classTeacher : classTeachers) {
                User teacher = userService.getById(classTeacher.getTeacherId());
                List<ExamPaper> examPapers = baseMapper.getFixedExamPaper(teacher.getUserName(), user.getUserLevel(), user.getUserName());
                fixedExamPaper.addAll(examPapers);
                // 查询时段试卷
                List<ExamPaper> examPapers1 = baseMapper.selectTimeLimitPaper(teacher.getUserName(), user.getUserLevel());
                timeLimitPaper.addAll(examPapers1);
                /*List<ExamPaper> examPapers2 = examPapers1.stream()
                .filter(examPaper -> examPaper.getLimitStartTime().compareTo(new Date()) == -1)
                .filter(examPaper -> examPaper.getLimitEndTime().compareTo(new Date()) == 1)
                .collect(Collectors.toList());*/
            }
            map.put("fixedPaper", fixedExamPaper);
            map.put("timeLimitPaper", timeLimitPaper);
            return Result.ok(map);
        } else {
            return Result.build(201, "请先加入班级！");
        }
    }

    @Override
    public Map<String, Object> selectExamPaperPage(ExamVM examVM) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        User user = userService.getUserByUserName(loginUser.getUsername());
        Page<ExamPaper> page = new Page<>(examVM.getPageIndex(), examVM.getPageSize());
        QueryWrapper<ExamPaper> wrapper = new QueryWrapper<>();
        wrapper.eq("grade_level", user.getUserLevel());
        wrapper.eq("paper_type", examVM.getPaperType());
        wrapper.eq("subject_id", examVM.getSubjectId());
        IPage<ExamPaper> examPaperPage = baseMapper.selectPage(page, wrapper);
        List<ExamPaper> list = examPaperPage.getRecords();
        long pageNum = examPaperPage.getCurrent();
        long total = examPaperPage.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("pageNum", pageNum);
        map.put("total", total);
        return map;
    }

    /**
     * 获取可视化的数据
     *
     * @param analyse
     * @return Map<String, List<Integer>>
     */
    @Override
    public Map<String, List<Integer>> getAnalyseData(AnalyseFrom analyse) {
        Date dateMonth = analyse.getNowMonth();
        User user = analyse.getCurrentUser();
        // 日期转为字符串
        String dateStr = DateTimeUtil.dateShortFormat(dateMonth);
        String[] split = dateStr.split("-");
        Map<String, List<Integer>> map = new HashMap<>();
        QueryWrapper<Subject> query = new QueryWrapper<>();
        query.eq("level", user.getUserLevel());
        // 获取学生所在年级的学科
        List<Subject> subjects = subjectDao.selectList(query);
        // 通过学科将所作过的试卷进行分类查询
        for (int i = 0; i < subjects.size(); i++) {
            List<Integer> dayCount = new ArrayList<>(32);
            for (int j = 1; j <= getMonthEndDay(split[0], split[1]); j++) {
                QueryWrapper<ExamPaperAnswer> wrapper = new QueryWrapper<>();
                wrapper.isNotNull("user_score");
                wrapper.apply("YEAR(create_time) = {0} AND MONTH(create_time) = {1} AND DAY(create_time) = {2}", split[0], split[1], j);
                wrapper.eq("create_user", user.getUserName());
                wrapper.eq("subject_id", subjects.get(i).getId());
                Integer count = examPaperAnswerDao.selectCount(wrapper);
                dayCount.add(count);
            }
            map.put(subjects.get(i).getName(), dayCount);
        }
        return map;
    }

    public Integer getMonthEndDay(String year, String month) {
        // 条件判断 1,3,5,7,8,10,12月为31天
        int monthInt = Integer.parseInt(month);
        int yearInt = Integer.parseInt(year);
        if (monthInt == 1 || monthInt == 3 || monthInt == 5 || monthInt == 7 || monthInt == 8 || monthInt == 10 || monthInt == 12) {
            return 31;
            // 条件判断 4，6，9，11月为31天
        } else if (monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11) {
            return 30;
        } else{
            //根据年来判断2月份的天数
            if ((yearInt % 100 != 0 && yearInt % 4 == 0) || yearInt % 400 == 0) {
                return 29;
            } else {
                return 28;
            }
        }
    }
}
