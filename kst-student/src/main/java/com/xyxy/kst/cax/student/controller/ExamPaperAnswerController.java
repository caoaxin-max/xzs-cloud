package com.xyxy.kst.cax.student.controller;

import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.student.service.ExamPaperAnswerService;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.ExamPagerAnswerPageVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.ExamPaperAnswerVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.PageVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/13/9:26
 */
@RestController
@RequestMapping("/api/student/exampaper/answer")
public class ExamPaperAnswerController {

    @Autowired
    private ExamPaperAnswerService examPaperAnswerService;

    @PostMapping("/answerSubmit")
    public Result answerSubmit(@RequestBody ExamPaperAnswerVM examPaperAnswerVM){
        Integer systemScore = examPaperAnswerService.saveExamPaperAnswer(examPaperAnswerVM);
        return Result.ok(systemScore);
    }

    @PostMapping("/read/{id}")
    public Result read(@PathVariable("id") Integer id){
        Map<String, Object> map = examPaperAnswerService.read(id);
        return Result.ok(map);
    }

    @PostMapping("/edit")
    public Result scoreAfterCorrection(@RequestBody ExamPaperAnswerVM examPaperAnswerVM){
        Integer result = examPaperAnswerService.scoreAfterCorrection(examPaperAnswerVM);
        return Result.ok(result);
    }

    @PostMapping("/pageList")
    public Result examPaperAnswerPage(@RequestBody ExamPagerAnswerPageVM pageVM){
        Map<String, Object> map = examPaperAnswerService.selectExamPaperAnswerPage(pageVM);
        return Result.ok(map);
    }
}
