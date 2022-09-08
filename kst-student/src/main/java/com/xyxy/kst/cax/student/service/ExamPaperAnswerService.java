package com.xyxy.kst.cax.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.ExamPaperAnswer;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.ExamPagerAnswerPageVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.ExamPaperAnswerVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.PageVM;

import java.util.Map;

public interface ExamPaperAnswerService extends IService<ExamPaperAnswer> {
    /**
     * 添加做试卷的答案
     * @param examPaperAnswerVM
     */
    Integer saveExamPaperAnswer(ExamPaperAnswerVM examPaperAnswerVM);

    /**
     * 查询
     * @param examPaperAnswerId
     * @return
     */
    Map<String, Object> read(Integer examPaperAnswerId);


    /**
     * 统计批改后的得分
     * @param examPaperAnswerVM
     * @return
     */
    Integer scoreAfterCorrection(ExamPaperAnswerVM examPaperAnswerVM);

    /**
     * 分页查询
     * @param pageVM
     * @return
     */
    Map<String, Object> selectExamPaperAnswerPage(ExamPagerAnswerPageVM pageVM);
}
