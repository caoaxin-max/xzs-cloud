package com.xyxy.kst.cax.service.impl;

import com.xyxy.kst.cax.service.*;
import com.xyxy.kst.cax.utils.DateTimeUtil;
import com.xyxy.kst.cax.viewmodel.admin.dashboard.IndexVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/25/17:16
 */
@Service
public class IndexVMServiceImpl implements IndexVMService {

    @Autowired
    private ExamPaperService examPaperService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ExamPaperAnswerService examPaperAnswerService;

    @Autowired
    private ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService;

    @Autowired
    private UserEventLogService userEventLogService;


    /**
     * 首页的数据 试卷数目、题目数目、累计答的试卷数量、累计打的题目数量
     * @return IndexVM indexVM
     */
    @Override
    public IndexVM getIndexVM() {
        IndexVM indexVM = new IndexVM();
        indexVM.setExamPaperCount(examPaperService.getExamPaperCount());
        indexVM.setQuestionCount(questionService.getQuestionCount());
        indexVM.setDoExamPaperCount(examPaperAnswerService.getExamPaperAnswerCount());
        indexVM.setDoQuestionCount(examPaperQuestionCustomerAnswerService.getEPQCustomerAnswerCount());
        indexVM.setMothDayUserActionValue(userEventLogService.oneMonthUserActive());
        indexVM.setMothDayDoExamQuestionValue(examPaperQuestionCustomerAnswerService.selectCountByDate());
        indexVM.setMothDayText(DateTimeUtil.MothDay());
        return indexVM;
    }
}
