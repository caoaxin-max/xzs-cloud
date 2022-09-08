package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.EPQCustomerAnswer;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.PageVM;

import java.util.List;
import java.util.Map;

public interface ExamPaperQuestionCustomerAnswerService extends IService<EPQCustomerAnswer> {

    Integer getEPQCustomerAnswerCount();

    /**
     * 查询某个时间段的题目作答数量
     * @return
     */
    List<Integer> selectCountByDate();


}
