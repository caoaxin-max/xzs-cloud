package com.xyxy.kst.cax.student.controller;

import com.xyxy.kst.cax.entity.Subject;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.student.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/20/15:10
 */
@RestController
@RequestMapping("/api/student/education/subject/")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/list")
    public Result getSubjectList(){
        List<Subject> subjects = subjectService.getSubjectList();
        return Result.ok(subjects);
    }
}
