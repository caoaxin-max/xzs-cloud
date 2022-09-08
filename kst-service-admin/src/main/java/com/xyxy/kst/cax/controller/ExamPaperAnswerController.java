package com.xyxy.kst.cax.controller;

import com.xyxy.kst.cax.remote.RemoteStudentExamPaperAnswer;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.ExamPaperAnswerService;
import com.xyxy.kst.cax.viewmodel.admin.examPaperAnswer.ExamPaperAnswerAdminVM;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.ExamPaperAnswerVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/6/9:49
 */
@RestController
@RequestMapping("/api/admin")
public class ExamPaperAnswerController {

    @Autowired
    private ExamPaperAnswerService examPaperAnswerService;

    @Autowired
    private RemoteStudentExamPaperAnswer remoteStudentExamPaperAnswer;

    /**
     * 分页条件查询
     * @param examPaperAnswerAdminVM
     * @return
     */
    @PostMapping("/examPaperAnswer/page")
    public Result examPaperAnswerPage(@RequestBody ExamPaperAnswerAdminVM examPaperAnswerAdminVM){
        Map<String, Object> map = examPaperAnswerService.examPaperAnswerPage(examPaperAnswerAdminVM);
        return Result.ok(map);
    }

    @PostMapping("/exampaper/answer/read/{id}")
    public Result read(@PathVariable("id") Integer id){
        Result read = remoteStudentExamPaperAnswer.read(id);
        return read;
    }

    @PostMapping("/exampaper/answer/edit")
    public Result edit(@RequestBody ExamPaperAnswerVM examPaperAnswerVM){
        Result result = remoteStudentExamPaperAnswer.edit(examPaperAnswerVM);
        return result;
    }
}
