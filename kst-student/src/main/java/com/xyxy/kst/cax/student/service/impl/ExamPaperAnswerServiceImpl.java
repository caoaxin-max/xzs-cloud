package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.*;
import com.xyxy.kst.cax.service.TaskExamService;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.student.dao.ExamPaperAnswerDao;

import com.xyxy.kst.cax.student.service.*;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamPaperTitleItemVM;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import com.xyxy.kst.cax.viewmodel.admin.question.QuestionEditRequestVM;
import com.xyxy.kst.cax.viewmodel.admin.task.TaskExamVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.ExamPagerAnswerPageVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.ExamPaperAnswerVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.ExamPaperDoAnswerVM;

import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.PageVM;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/13/10:31
 */
@Service
public class ExamPaperAnswerServiceImpl extends ServiceImpl<ExamPaperAnswerDao, ExamPaperAnswer> implements ExamPaperAnswerService {

    @Autowired
    private ExamPaperService examPaperService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ExamPaperQuestionCustomerAnswerService EPQCAnswerService;

    @Autowired
    private TaskExamService taskExamService;

    @Autowired
    private SubjectService subjectService;

    @Transactional
    @Override
    public Integer saveExamPaperAnswer(ExamPaperAnswerVM examPaperAnswerVM) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        ExamPaper examPaper = examPaperService.getById(examPaperAnswerVM.getId());
        // 给ExamPaperAnswer添加数据
        ExamPaperAnswer examPaperAnswer = new ExamPaperAnswer();
        examPaperAnswer.setExamPaperId(examPaperAnswerVM.getId());
        examPaperAnswer.setPaperName(examPaper.getName());
        examPaperAnswer.setPaperType(examPaper.getPaperType());
        examPaperAnswer.setSubjectId(examPaper.getSubjectId());
        examPaperAnswer.setGradeLevel(examPaper.getGradeLevel());
        examPaperAnswer.setPaperScore(examPaper.getScore());
        examPaperAnswer.setQuestionCount(examPaper.getQuestionCount());
        examPaperAnswer.setDoTime(examPaperAnswerVM.getDoTime());
        examPaperAnswer.setStatus(1);
        examPaperAnswer.setCreateUser(loginUser.getUsername());
        examPaperAnswer.setCreateTime(new Date());
        if (examPaper.getTaskExamId() != null){
            examPaperAnswer.setTaskExamId(examPaper.getTaskExamId());
            TaskExam taskExam = taskExamService.getById(examPaper.getTaskExamId());
            List<ExamVM> examVMS = JsonUtil.toJsonListObject(taskExam.getTextContent(), ExamVM.class);
            for (ExamVM examVM : examVMS){
                if (examVM.getId() == examPaper.getId()){
                    examVM.setStatus(1);
                }
            }
            String toJsonStr = JsonUtil.toJsonStr(examVMS);
            taskExam.setTextContent(toJsonStr);
            taskExamService.updateById(taskExam);
        }
        int insert = baseMapper.insert(examPaperAnswer);
        int systemScore = 0;
        int questionCorrect = 0;
        if (insert > 0) {
            if (examPaper.getPaperType() == 6){
                TaskExam taskExam = taskExamService.getById(examPaperAnswer.getTaskExamId());
                List<ExamVM> examVMS = JsonUtil.toJsonListObject(taskExam.getTextContent(), ExamVM.class);
                for (ExamVM examVM : examVMS){
                    examVM.setExamPaperAnswerId(examPaperAnswer.getId());
                }
                String toJsonStr = JsonUtil.toJsonStr(examVMS);
                taskExam.setTextContent(toJsonStr);
                taskExamService.updateById(taskExam);
            }

            for (ExamPaperDoAnswerVM examPaperDoAnswerVM : examPaperAnswerVM.getAnswerItems()) {
                Question question = questionService.getById(examPaperDoAnswerVM.getQuestionId());
                if (question.getQuestionType() == 2) {
                    List<String> correctArray = JsonUtil.toJsonListObject(question.getCorrect(), String.class);
                    boolean equalCollection = CollectionUtils.isEqualCollection(correctArray, examPaperDoAnswerVM.getContentArray());
                    if (equalCollection) {
                        systemScore += question.getScore();
                        questionCorrect++;
                        EPQCustomerAnswer epqCustomerAnswer = new EPQCustomerAnswer();
                        epqCustomerAnswer.setQuestionId(examPaperDoAnswerVM.getQuestionId());
                        epqCustomerAnswer.setExamPaperId(examPaper.getId());
                        epqCustomerAnswer.setQuestionType(question.getQuestionType());
                        epqCustomerAnswer.setSubjectId(question.getSubjectId());
                        epqCustomerAnswer.setExamPaperAnswerId(examPaperAnswer.getId());
                        epqCustomerAnswer.setCustomerScore(question.getScore());
                        epqCustomerAnswer.setQuestionScore(question.getScore());
                        epqCustomerAnswer.setQuestionTextContent(question.getTextContent());
                        epqCustomerAnswer.setAnswer(JsonUtil.toJsonStr(examPaperDoAnswerVM.getContentArray()));
//                        epqCustomerAnswer.setTextContent(JsonUtil.toJsonStr(examPaperDoAnswerVM));
                        epqCustomerAnswer.setDoRight(true);
                        epqCustomerAnswer.setCreateUser(loginUser.getUsername());
                        epqCustomerAnswer.setCreateTime(new Date());
                        boolean save = EPQCAnswerService.save(epqCustomerAnswer);
                        if (save){
                            examPaperDoAnswerVM.setEpqCustomerAnswerId(epqCustomerAnswer.getId());
                            examPaperDoAnswerVM.setDoRight(true);
                            epqCustomerAnswer.setTextContent(JsonUtil.toJsonStr(examPaperDoAnswerVM));
                            EPQCAnswerService.updateById(epqCustomerAnswer);
                        }
                    } else {
                        EPQCustomerAnswer epqCustomerAnswer = new EPQCustomerAnswer();
                        epqCustomerAnswer.setQuestionId(examPaperDoAnswerVM.getQuestionId());
                        epqCustomerAnswer.setExamPaperId(examPaper.getId());
                        epqCustomerAnswer.setQuestionType(question.getQuestionType());
                        epqCustomerAnswer.setSubjectId(question.getSubjectId());
                        epqCustomerAnswer.setExamPaperAnswerId(examPaperAnswer.getId());
                        epqCustomerAnswer.setCustomerScore(0);
                        epqCustomerAnswer.setQuestionScore(question.getScore());
                        epqCustomerAnswer.setQuestionTextContent(question.getTextContent());
                        epqCustomerAnswer.setAnswer(JsonUtil.toJsonStr(examPaperDoAnswerVM.getContentArray()));
                        epqCustomerAnswer.setTextContent(JsonUtil.toJsonStr(examPaperDoAnswerVM));
                        epqCustomerAnswer.setDoRight(false);
                        epqCustomerAnswer.setCreateUser(loginUser.getUsername());
                        epqCustomerAnswer.setCreateTime(new Date());
                        boolean save = EPQCAnswerService.save(epqCustomerAnswer);
                        if (save){
                            examPaperDoAnswerVM.setDoRight(false);
                            examPaperDoAnswerVM.setEpqCustomerAnswerId(epqCustomerAnswer.getId());
                            epqCustomerAnswer.setTextContent(JsonUtil.toJsonStr(examPaperDoAnswerVM));
                            EPQCAnswerService.updateById(epqCustomerAnswer);
                        }
                    }
                } else if (question.getQuestionType() == 1 || question.getQuestionType() == 3 || question.getQuestionType() == 4) {
                    if (question.getCorrect().equals(examPaperDoAnswerVM.getContent())) {
                        systemScore += question.getScore();
                        questionCorrect++;
                        EPQCustomerAnswer epqCustomerAnswer = new EPQCustomerAnswer();
                        epqCustomerAnswer.setQuestionId(examPaperDoAnswerVM.getQuestionId());
                        epqCustomerAnswer.setExamPaperId(examPaper.getId());
                        epqCustomerAnswer.setQuestionType(question.getQuestionType());
                        epqCustomerAnswer.setExamPaperAnswerId(examPaperAnswer.getId());
                        epqCustomerAnswer.setSubjectId(question.getSubjectId());
                        epqCustomerAnswer.setCustomerScore(question.getScore());
                        epqCustomerAnswer.setQuestionScore(question.getScore());
                        epqCustomerAnswer.setQuestionTextContent(question.getTextContent());
                        epqCustomerAnswer.setAnswer(examPaperDoAnswerVM.getContent());
                        epqCustomerAnswer.setTextContent(JsonUtil.toJsonStr(examPaperDoAnswerVM));
                        epqCustomerAnswer.setDoRight(true);
                        epqCustomerAnswer.setCreateUser(loginUser.getUsername());
                        epqCustomerAnswer.setCreateTime(new Date());
                        boolean save = EPQCAnswerService.save(epqCustomerAnswer);
                        if (save){
                            examPaperDoAnswerVM.setDoRight(true);
                            examPaperDoAnswerVM.setEpqCustomerAnswerId(epqCustomerAnswer.getId());
                            epqCustomerAnswer.setTextContent(JsonUtil.toJsonStr(examPaperDoAnswerVM));
                            EPQCAnswerService.updateById(epqCustomerAnswer);
                        }
                    } else {
                        EPQCustomerAnswer epqCustomerAnswer = new EPQCustomerAnswer();
                        epqCustomerAnswer.setQuestionId(examPaperDoAnswerVM.getQuestionId());
                        epqCustomerAnswer.setExamPaperId(examPaper.getId());
                        epqCustomerAnswer.setQuestionType(question.getQuestionType());
                        epqCustomerAnswer.setExamPaperAnswerId(examPaperAnswer.getId());
                        epqCustomerAnswer.setSubjectId(question.getSubjectId());
                        epqCustomerAnswer.setCustomerScore(0);
                        epqCustomerAnswer.setQuestionScore(question.getScore());
                        epqCustomerAnswer.setQuestionTextContent(question.getTextContent());
                        epqCustomerAnswer.setAnswer(examPaperDoAnswerVM.getContent());
                        epqCustomerAnswer.setTextContent(JsonUtil.toJsonStr(examPaperDoAnswerVM));
                        epqCustomerAnswer.setDoRight(false);
                        epqCustomerAnswer.setCreateUser(loginUser.getUsername());
                        epqCustomerAnswer.setCreateTime(new Date());
                        boolean save = EPQCAnswerService.save(epqCustomerAnswer);
                        if (save){
                            examPaperDoAnswerVM.setDoRight(false);
                            examPaperDoAnswerVM.setEpqCustomerAnswerId(epqCustomerAnswer.getId());
                            epqCustomerAnswer.setTextContent(JsonUtil.toJsonStr(examPaperDoAnswerVM));
                            EPQCAnswerService.updateById(epqCustomerAnswer);
                        }
                    }
                }else {
                    EPQCustomerAnswer epqCustomerAnswer = new EPQCustomerAnswer();
                    epqCustomerAnswer.setQuestionId(examPaperDoAnswerVM.getQuestionId());
                    epqCustomerAnswer.setExamPaperId(examPaper.getId());
                    epqCustomerAnswer.setQuestionType(question.getQuestionType());
                    epqCustomerAnswer.setExamPaperAnswerId(examPaperAnswer.getId());
                    epqCustomerAnswer.setSubjectId(question.getSubjectId());
                    epqCustomerAnswer.setCustomerScore(0);
                    epqCustomerAnswer.setQuestionScore(question.getScore());
                    epqCustomerAnswer.setQuestionTextContent(question.getTextContent());
                    epqCustomerAnswer.setAnswer(examPaperDoAnswerVM.getContent());
                    epqCustomerAnswer.setTextContent(JsonUtil.toJsonStr(examPaperDoAnswerVM));
                    epqCustomerAnswer.setCreateUser(loginUser.getUsername());
                    epqCustomerAnswer.setCreateTime(new Date());
                    boolean save = EPQCAnswerService.save(epqCustomerAnswer);
                    if (save){
                        examPaperDoAnswerVM.setEpqCustomerAnswerId(epqCustomerAnswer.getId());
                        epqCustomerAnswer.setTextContent(JsonUtil.toJsonStr(examPaperDoAnswerVM));
                        EPQCAnswerService.updateById(epqCustomerAnswer);
                    }
                }
            }
            ExamPaperAnswer examPaperAnswer1 = baseMapper.selectById(examPaperAnswer.getId());
            if (examPaperAnswer1 != null){
                examPaperAnswer1.setSystemScore(systemScore);
                examPaperAnswer1.setQuestionCorrect(questionCorrect);
                baseMapper.updateById(examPaperAnswer1);
            }
        }
        return systemScore;
    }

    /**
     * 显示去批改里面的内容
     * @param examPaperAnswerId
     * @return
     */
    @Transactional
    @Override
    public Map<String, Object> read(Integer examPaperAnswerId) {
        ExamPaperAnswer examPaperAnswer = baseMapper.selectById(examPaperAnswerId);
        // 准备paper数据
        ExamPaper examPaper = examPaperService.getById(examPaperAnswer.getExamPaperId());
        ExamVM examVM = JsonUtil.toJsonObject(JsonUtil.toJsonStr(examPaper), ExamVM.class);
        List<ExamPaperTitleItemVM> examPaperTitleItemVMS = JsonUtil.toJsonListObject(examPaper.getTextContent(), ExamPaperTitleItemVM.class);
        int i = 1;
        for (ExamPaperTitleItemVM examPaperTitleItemVM : examPaperTitleItemVMS){
            List<QuestionEditRequestVM> questionItems = examPaperTitleItemVM.getQuestionItems();
            for (QuestionEditRequestVM questionEditRequestVM : questionItems){
                questionEditRequestVM.setItemOrder(i++);
            }

        }
        examVM.setTitleItems(examPaperTitleItemVMS);

        // 准备answer数据
        ExamPaperAnswerVM examPaperAnswerVM = new ExamPaperAnswerVM();
        examPaperAnswerVM.setId(examPaperAnswer.getId());
        if (examPaperAnswer.getUserScore() == null){
            examPaperAnswerVM.setScore(examPaperAnswer.getSystemScore());
        }else {
            examPaperAnswerVM.setScore(examPaperAnswer.getUserScore());
        }
        examPaperAnswerVM.setDoTime(examPaperAnswer.getDoTime());
        QueryWrapper<EPQCustomerAnswer> wrapper = new QueryWrapper<>();
        wrapper.eq("exam_paper_answer_id", examPaperAnswerId);
        List<EPQCustomerAnswer> epqCustomerAnswerList = EPQCAnswerService.list(wrapper);
        List<ExamPaperDoAnswerVM> answerItems = new ArrayList<>();
        for (EPQCustomerAnswer epqCustomerAnswer : epqCustomerAnswerList){
            String examPaperDoAnswerVMJsonString = epqCustomerAnswer.getTextContent();
            ExamPaperDoAnswerVM examPaperDoAnswerVM = JsonUtil.toJsonObject(examPaperDoAnswerVMJsonString, ExamPaperDoAnswerVM.class);
            if (epqCustomerAnswer.getDoRight() != null){
                examPaperDoAnswerVM.setDoRight(epqCustomerAnswer.getDoRight());
            }else {
                examPaperDoAnswerVM.setDoRight(null);
            }
            answerItems.add(examPaperDoAnswerVM);
        }
        examPaperAnswerVM.setAnswerItems(answerItems);
        Map<String,Object> map = new HashMap<>();
        map.put("paper", examVM);
        map.put("answer", examPaperAnswerVM);
        map.put("answerUser", examPaperAnswer.getCreateUser());
        return map;
    }

    /**
     * 统计批改后的得分
     * @param examPaperAnswerVM
     * @return
     */
    @Transactional
    @Override
    public Integer scoreAfterCorrection(ExamPaperAnswerVM examPaperAnswerVM) {
        int totalScore = 0;
        for(ExamPaperDoAnswerVM answerItem : examPaperAnswerVM.getAnswerItems()){
            Question question = questionService.getById(answerItem.getQuestionId());
            if (question.getQuestionType() == 5){
                totalScore = answerItem.getScore()+totalScore;
                EPQCustomerAnswer epqCustomerAnswer = EPQCAnswerService.getById(answerItem.getEpqCustomerAnswerId());
                ExamPaperDoAnswerVM examPaperDoAnswerVM = JsonUtil.toJsonObject(epqCustomerAnswer.getTextContent(), ExamPaperDoAnswerVM.class);
                LambdaUpdateWrapper<EPQCustomerAnswer> wrapper = new LambdaUpdateWrapper<>();
                wrapper.set(EPQCustomerAnswer::getCustomerScore, answerItem.getScore());
                if (answerItem.getScore() == question.getScore()){
                    wrapper.set(EPQCustomerAnswer::getDoRight, true);
                    examPaperDoAnswerVM.setDoRight(true);
                }else {
                    wrapper.set(EPQCustomerAnswer::getDoRight, false);
                    examPaperDoAnswerVM.setDoRight(false);
                }
                wrapper.set(EPQCustomerAnswer::getTextContent, JsonUtil.toJsonStr(examPaperDoAnswerVM));
                wrapper.eq(EPQCustomerAnswer::getId, answerItem.getEpqCustomerAnswerId());
                EPQCAnswerService.update(wrapper);
            }
        }
        totalScore += examPaperAnswerVM.getScore();
        ExamPaperAnswer examPaperAnswer = baseMapper.selectById(examPaperAnswerVM.getId());
        if (examPaperAnswer != null){
            examPaperAnswer.setUserScore(totalScore);
            examPaperAnswer.setStatus(2);
            baseMapper.updateById(examPaperAnswer);
            if (examPaperAnswer.getPaperType() == 6){
                TaskExam taskExam = taskExamService.getById(examPaperAnswer.getTaskExamId());
                List<ExamVM> examVMS = JsonUtil.toJsonListObject(taskExam.getTextContent(), ExamVM.class);
                for (ExamVM examVM : examVMS){
                    examVM.setStatus(2);
                }
                String toJsonStr = JsonUtil.toJsonStr(examVMS);
                LambdaUpdateWrapper<TaskExam> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
                lambdaUpdateWrapper.eq(TaskExam::getId, examPaperAnswer.getTaskExamId());
                lambdaUpdateWrapper.set(TaskExam::getTextContent, toJsonStr);
                taskExamService.update(lambdaUpdateWrapper);
            }
        }
        return totalScore;
    }


    /***
     * 分页查询
     * @param pageVM
     * @return
     */
    @Override
    public Map<String, Object> selectExamPaperAnswerPage(ExamPagerAnswerPageVM pageVM) {
        User currentUser = pageVM.getCurrentUser();
        QueryWrapper<ExamPaperAnswer> wrapper = new QueryWrapper<>();
        wrapper.eq("create_user", currentUser.getUserName());
        Page<ExamPaperAnswer> page = new Page<>(pageVM.getPageIndex(), pageVM.getPageSize());
        IPage<ExamPaperAnswer> examPaperAnswerPage = baseMapper.selectPage(page, wrapper);
        long total = examPaperAnswerPage.getTotal();
        List<ExamPaperAnswer> list = examPaperAnswerPage.getRecords();
        for (ExamPaperAnswer examPaperAnswer : list){
            Subject subject = subjectService.getById(examPaperAnswer.getSubjectId());
            switch (subject.getLevel()){
                case 1:
                    examPaperAnswer.setSubjectName(subject.getName()+"(一年级)");
                    break;
                case 2:
                    examPaperAnswer.setSubjectName(subject.getName()+"(二年级)");
                    break;
                case 3:
                    examPaperAnswer.setSubjectName(subject.getName()+"(三年级)");
                    break;
                case 4:
                    examPaperAnswer.setSubjectName(subject.getName()+"(四年级)");
                    break;
                case 5:
                    examPaperAnswer.setSubjectName(subject.getName()+"(五年级)");
                    break;
                case 6:
                    examPaperAnswer.setSubjectName(subject.getName()+"(六年级)");
                    break;
                case 7:
                    examPaperAnswer.setSubjectName(subject.getName()+"(初一年级)");
                    break;
                case 8:
                    examPaperAnswer.setSubjectName(subject.getName()+"(初二年级)");
                    break;
                case 9:
                    examPaperAnswer.setSubjectName(subject.getName()+"(初三年级)");
                    break;
                case 10:
                    examPaperAnswer.setSubjectName(subject.getName()+"(高一年级)");
                    break;
                case 11:
                    examPaperAnswer.setSubjectName(subject.getName()+"(高二年级)");
                    break;
                case 12:
                    examPaperAnswer.setSubjectName(subject.getName()+"(高三年级)");
                    break;
            }
        }
        long pageNum = examPaperAnswerPage.getCurrent();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("list", list);
        map.put("pageNum", pageNum);
        return map;
    }
}
