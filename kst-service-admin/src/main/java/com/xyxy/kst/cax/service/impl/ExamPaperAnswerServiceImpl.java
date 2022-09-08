package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.ClassDao;
import com.xyxy.kst.cax.dao.ClassTeacherDao;
import com.xyxy.kst.cax.dao.ExamPaperAnswerDao;
import com.xyxy.kst.cax.dao.UserDao;
import com.xyxy.kst.cax.entity.ClassTeacher;
import com.xyxy.kst.cax.entity.ExamPaperAnswer;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.service.ExamPaperAnswerService;
import com.xyxy.kst.cax.service.UserService;
import com.xyxy.kst.cax.viewmodel.admin.examPaperAnswer.ExamPaperAnswerAdminVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/25/17:07
 */
@Service
public class ExamPaperAnswerServiceImpl extends ServiceImpl<ExamPaperAnswerDao, ExamPaperAnswer> implements ExamPaperAnswerService
{

    @Autowired
    private ClassDao classDao;

    @Autowired
    private ClassTeacherDao classTeacherDao;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    /**
     * 获取累计答试卷总数
     */
    @Override
    public Integer getExamPaperAnswerCount(){
        QueryWrapper<ExamPaperAnswer> wrapper = new QueryWrapper<>();
        Integer examPaperAnswerCount = baseMapper.selectCount(wrapper);
        return examPaperAnswerCount;
    }

    /**
     * 查询这个月每天所做的题目数量
     * @return
     */
    @Override
    public Map<Date, Long> oneMonthDayDoExamQuestion() {
        List<ExamPaperAnswer> examPaperAnswers = baseMapper.oneMonthDoExamQuestion();
        Map<Date, Long> oneMonthDayDoExamQuestionMap = examPaperAnswers.stream()
                .collect(Collectors.groupingBy(ExamPaperAnswer::getCreateTime,
                        Collectors.summingLong(ExamPaperAnswer::getQuestionCount)));
        return oneMonthDayDoExamQuestionMap;
    }

    /**
     *
     */
    @Override
    public void saveExamPaper(ExamPaperAnswer examPaperAnswer) {
        baseMapper.insert(examPaperAnswer);
    }

    /**
     * 更新
     * @param examPaperAnswer
     */
    @Override
    public void updateExamPaperAnswer(ExamPaperAnswer examPaperAnswer) {
        baseMapper.updateById(examPaperAnswer);
    }

    /**
     * 根据examPaperId查询ExamPaperAnswer
     * @param examPaperId
     * @return
     */
    @Override
    public ExamPaperAnswer selectByExamPaperId(Integer examPaperId) {
        QueryWrapper<ExamPaperAnswer> wrapper = new QueryWrapper<>();
        wrapper.eq("exam_paper_id", examPaperId);
        ExamPaperAnswer examPaperAnswer = baseMapper.selectOne(wrapper);
        return examPaperAnswer;
    }

    /**
     * 分页条件查询
     * @param examPaperAnswerAdminVM
     * @return
     */
    @Override
    public Map<String, Object> examPaperAnswerPage(ExamPaperAnswerAdminVM examPaperAnswerAdminVM) {
        User user = userService.getUserByUserName(examPaperAnswerAdminVM.getCurrentUser());
        if (user.getRole() == 3){
            Page<ExamPaperAnswer> page = new Page<>(examPaperAnswerAdminVM.getPageIndex(), examPaperAnswerAdminVM.getPageSize());
            IPage<ExamPaperAnswer> examPaperAnswerIPage = baseMapper.examPaperAnswerPage(page, examPaperAnswerAdminVM);
            List<ExamPaperAnswer> examPaperAnswerList = examPaperAnswerIPage.getRecords();
            long pageNum = examPaperAnswerIPage.getCurrent();
            long total = examPaperAnswerIPage.getTotal();
            Map<String, Object> map = new HashMap<>();
            map.put("list", examPaperAnswerList);
            map.put("pageNum", pageNum);
            map.put("total", total);
            return map;
        }else {
            QueryWrapper<ClassTeacher> wrapper = new QueryWrapper<>();
            wrapper.eq("teacher_id", user.getId());
            List<ClassTeacher> classTeachers = classTeacherDao.selectList(wrapper);
            if (classTeachers.size() <= 0){
                Map<String, Object> map = new HashMap<>();
                map.put("message", "该老师没有分配班级！");
                return map;
            }else {
                List<Integer> classIdList = classTeachers.stream().map(ClassTeacher::getClassId).collect(Collectors.toList());
                QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("class_id", classIdList);
                List<User> users = userDao.selectList(queryWrapper);
                if (users.size() <= 0){
                    Map<String, Object> map = new HashMap<>();
                    map.put("message", "该老师班级没有加入学生！");
                    return map;
                }else {
                    Page<ExamPaperAnswer> page = new Page<>(examPaperAnswerAdminVM.getPageIndex(), examPaperAnswerAdminVM.getPageSize());
                    IPage<ExamPaperAnswer> examPaperAnswerIPage = baseMapper.examPaperAnswerByStudentPage(page, examPaperAnswerAdminVM, users);
                    List<ExamPaperAnswer> examPaperAnswerList = examPaperAnswerIPage.getRecords();
                    long pageNum = examPaperAnswerIPage.getCurrent();
                    long total = examPaperAnswerIPage.getTotal();
                    Map<String, Object> map = new HashMap<>();
                    map.put("list", examPaperAnswerList);
                    map.put("pageNum", pageNum);
                    map.put("total", total);
                    return map;
                }

            }
        }
    }
}
