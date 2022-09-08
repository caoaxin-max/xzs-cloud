package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.Class;
import com.xyxy.kst.cax.entity.ClassTeacher;
import com.xyxy.kst.cax.entity.ExamPaper;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.student.dao.ExamPaperDao;
import com.xyxy.kst.cax.student.service.ClassService;
import com.xyxy.kst.cax.student.service.ClassTeacherService;
import com.xyxy.kst.cax.student.service.ExamPaperService;
import com.xyxy.kst.cax.student.service.UserService;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 查询固定试卷和时段试卷
     * @return
     */
    @Override
    public Result selectExamPaper(Integer userId) {
        User user = userService.getById(userId);
        if (user.getClassId() != 0){
            Map<String, Object> map = new HashMap<>();
            List<ExamPaper> fixedExamPaper = new ArrayList<>();
            List<ExamPaper> timeLimitPaper = new ArrayList<>();
            List<ClassTeacher> classTeachers = classTeacherService.getClassTeacher(user.getClassId());
            for (ClassTeacher classTeacher : classTeachers) {
                User teacher = userService.getById(classTeacher.getTeacherId());
                List<ExamPaper> examPapers = baseMapper.getFixedExamPaper(teacher.getUserName(), user.getUserLevel());
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
        }else {
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
}
