package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.EPQCustomerAnswer;
import com.xyxy.kst.cax.entity.Question;
import com.xyxy.kst.cax.entity.Subject;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.student.dao.ExamPaperQuestionCustomerAnswerDao;
import com.xyxy.kst.cax.student.service.ExamPaperQuestionCustomerAnswerService;
import com.xyxy.kst.cax.student.service.QuestionService;
import com.xyxy.kst.cax.student.service.SubjectService;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.question.QuestionEditRequestVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.ExamPaperDoAnswerVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.PageVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperCustomerAnswer.QuestionAnswerVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/13/15:27
 */
@Service
public class ExamPaperQuestionCustomerAnswerServiceImpl extends ServiceImpl<ExamPaperQuestionCustomerAnswerDao, EPQCustomerAnswer> implements ExamPaperQuestionCustomerAnswerService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private QuestionService questionService;

    /**
     * 分页查询
     *
     * @param pageVM
     * @return
     */
    @Override
    public Map<String, Object> selectEPQPage(PageVM pageVM) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);

        Page<EPQCustomerAnswer> page = new Page<>(pageVM.getPageIndex(), pageVM.getPageSize());
        QueryWrapper<EPQCustomerAnswer> wrapper = new QueryWrapper<>();
        wrapper.eq("do_right", false);
        wrapper.eq("create_user", loginUser.getUsername());
        IPage<EPQCustomerAnswer> epqCustomerAnswerPage = baseMapper.selectPage(page, wrapper);
        long total = epqCustomerAnswerPage.getTotal();
        long pageNum = epqCustomerAnswerPage.getCurrent();
        List<EPQCustomerAnswer> epqCustomerAnswers = epqCustomerAnswerPage.getRecords();
        List<QuestionAnswerVM> list = new ArrayList<>();
        for (EPQCustomerAnswer epqCustomerAnswer : epqCustomerAnswers) {
            QuestionAnswerVM questionAnswerVM = new QuestionAnswerVM();
            questionAnswerVM.setId(epqCustomerAnswer.getId());
            questionAnswerVM.setCreateTime(epqCustomerAnswer.getCreateTime());
            questionAnswerVM.setQuestionType(epqCustomerAnswer.getQuestionType());
            QuestionEditRequestVM questionEditRequestVM = JsonUtil.toJsonObject(epqCustomerAnswer.getQuestionTextContent(), QuestionEditRequestVM.class);
            questionAnswerVM.setShortTitle(questionEditRequestVM.getTitle());
            Subject subject = subjectService.getById(epqCustomerAnswer.getSubjectId());
            switch (subject.getLevel()) {
                case 1:
                    questionAnswerVM.setSubjectName(subject.getName() + "(一年级)");
                    break;
                case 2:
                    questionAnswerVM.setSubjectName(subject.getName() + "(二年级)");
                    break;
                case 3:
                    questionAnswerVM.setSubjectName(subject.getName() + "(三年级)");
                    break;
                case 4:
                    questionAnswerVM.setSubjectName(subject.getName() + "(四年级)");
                    break;
                case 5:
                    questionAnswerVM.setSubjectName(subject.getName() + "(五年级)");
                    break;
                case 6:
                    questionAnswerVM.setSubjectName(subject.getName() + "(六年级)");
                    break;
                case 7:
                    questionAnswerVM.setSubjectName(subject.getName() + "(初一年级)");
                    break;
                case 8:
                    questionAnswerVM.setSubjectName(subject.getName() + "(初二年级)");
                    break;
                case 9:
                    questionAnswerVM.setSubjectName(subject.getName() + "(初三年级)");
                    break;
                case 10:
                    questionAnswerVM.setSubjectName(subject.getName() + "(高一年级)");
                    break;
                case 11:
                    questionAnswerVM.setSubjectName(subject.getName() + "(高二年级)");
                    break;
                case 12:
                    questionAnswerVM.setSubjectName(subject.getName() + "(高三年级)");
                    break;
            }
            list.add(questionAnswerVM);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("pageNum", pageNum);
        map.put("list", list);
        return map;
    }


    /**
     * 通过id查询
     *
     * @param epqCustomerAnswerId
     * @return
     */
    @Override
    public Map<String, Object> selectEPQById(Integer epqCustomerAnswerId) {
        Map<String, Object> map = new HashMap<>();
        EPQCustomerAnswer epqCustomerAnswer = baseMapper.selectById(epqCustomerAnswerId);
        if (epqCustomerAnswer != null) {
            ExamPaperDoAnswerVM examPaperDoAnswerVM = JsonUtil.toJsonObject(epqCustomerAnswer.getTextContent(), ExamPaperDoAnswerVM.class);
            Question question = questionService.getById(epqCustomerAnswer.getQuestionId());
            QuestionEditRequestVM questionEditRequestVM = JsonUtil.toJsonObject(question.getTextContent(), QuestionEditRequestVM.class);
            questionEditRequestVM.setQuestionType(question.getQuestionType());
            if (question.getQuestionType() == 2) {
                List<String> list = JsonUtil.toJsonListObject(question.getCorrect(), String.class);
                questionEditRequestVM.setCorrectArray(list);
            } else {
                questionEditRequestVM.setCorrect(question.getCorrect());
            }
            questionEditRequestVM.setDifficult(question.getDifficult());
            map.put("questionVM", questionEditRequestVM);
            map.put("questionAnswerVM", examPaperDoAnswerVM);
        }
        return map;
    }
}
