package com.xyxy.kst.cax.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.EPQCustomerAnswer;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.PageVM;

import java.util.Map;

public interface ExamPaperQuestionCustomerAnswerService extends IService<EPQCustomerAnswer> {
    /**
     * 分页查询
     * @param pageVM
     * @return
     */
    Map<String, Object> selectEPQPage(PageVM pageVM);

    /**
     * 通过id查询
     * @param epqCustomerAnswerId
     * @return
     */
    Map<String, Object> selectEPQById(Integer epqCustomerAnswerId);
}
