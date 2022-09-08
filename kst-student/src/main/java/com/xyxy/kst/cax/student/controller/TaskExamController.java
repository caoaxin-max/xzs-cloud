package com.xyxy.kst.cax.student.controller;

import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.TaskExamService;
import com.xyxy.kst.cax.viewmodel.admin.task.TaskExamVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/6/15:49
 */
@RestController
@RequestMapping("/api/student")
public class TaskExamController {

    @Autowired
    private TaskExamService taskExamService;

    @PostMapping("/dashboard/task/{level}")
    public Result dashboardTask(@PathVariable Integer level){
        List<TaskExamVM> list = taskExamService.selectTaskAll(level);
        return Result.ok(list);
    }



}
