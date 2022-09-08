package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.ExamPaperAnswer;
import com.xyxy.kst.cax.viewmodel.admin.examPaperAnswer.ExamPaperAnswerAdminVM;

import java.util.Date;
import java.util.Map;


public interface ExamPaperAnswerService extends IService<ExamPaperAnswer> {
    Integer getExamPaperAnswerCount();

    /**
     * 查询这个月每天所做的题目数量
     * @return
     */
    Map<Date, Long> oneMonthDayDoExamQuestion();

    /**
     * 插入试卷内容
     */
    void saveExamPaper(ExamPaperAnswer examPaperAnswer);

    /**
     * 更新
     * @param examPaperAnswer
     */
    void updateExamPaperAnswer(ExamPaperAnswer examPaperAnswer);

    /**
     * 根据examPaperId查询ExamPaperAnswer
     * @param examPaperId
     * @return
     */
    ExamPaperAnswer selectByExamPaperId(Integer examPaperId);


    /**
     * 分页条件查询
     * @param examPaperAnswerAdminVM
     * @return
     */
    Map<String, Object> examPaperAnswerPage(ExamPaperAnswerAdminVM examPaperAnswerAdminVM);
}
