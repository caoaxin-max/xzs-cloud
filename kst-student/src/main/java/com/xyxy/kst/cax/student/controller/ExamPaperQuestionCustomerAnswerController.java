package com.xyxy.kst.cax.student.controller;

import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.student.service.ExamPaperQuestionCustomerAnswerService;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.PageVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/21/15:10
 */
@RestController
@RequestMapping("/api/student/question/answer")
public class ExamPaperQuestionCustomerAnswerController {

    @Autowired
    private ExamPaperQuestionCustomerAnswerService EPQCustomerAnswerService;

    /**
     * 分页查询
     * @param pageVM
     * @return
     */
    @PostMapping("/page")
    public Result selectEPQPage(@RequestBody PageVM pageVM){
        Map<String, Object> map = EPQCustomerAnswerService.selectEPQPage(pageVM);
        return Result.ok(map);
    }

    /**
     * 通过id查询
     * @param epqCustomerAnswerId
     * @return
     */
    @PostMapping("/select/{id}")
    public Result selectEPQById(@PathVariable("id") Integer epqCustomerAnswerId){
        Map<String, Object> map = EPQCustomerAnswerService.selectEPQById(epqCustomerAnswerId);
        return Result.ok(map);
    }
}
