package com.xyxy.kst.cax.remote;

import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.ExamPaperAnswerVM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "remoteStudentExamPaperAnswer", value = "kst-student")
public interface RemoteStudentExamPaperAnswer {

    @PostMapping("/api/student/exampaper/answer/read/{id}")
    public Result read(@PathVariable("id") Integer id);


    @PostMapping("/api/student/exampaper/answer/edit")
    public Result edit(@RequestBody ExamPaperAnswerVM examPaperAnswerVM);
}
