package com.xyxy.kst.cax.controller;

import com.xyxy.kst.cax.entity.TaskExam;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.TaskExamService;
import com.xyxy.kst.cax.viewmodel.admin.task.TaskExamVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/22/19:51
 */
@RestController
@RequestMapping("/api/admin")
public class TaskExamController {

    @Autowired
    private TaskExamService taskExamService;

    /**
     * 分页条件查询任务
     * @param taskExamVM
     * @return
     */
    @PostMapping("/task/page")
    public Result selectTaskExamPage(@RequestBody TaskExamVM taskExamVM){
        Map<String, Object> map = taskExamService.selectTaskExamPage(taskExamVM);
        return Result.ok(map);
    }

    /**
     * 创建或者更新任务
     * @param taskExamVM
     * @return
     */
    @PostMapping("/task/edit")
    public Result createOrUpdateTask(@RequestBody TaskExamVM taskExamVM){
        String message = taskExamService.createOrUpdateTask(taskExamVM);
        return Result.ok(message);
    }

    /**
     * 根据id查询任务
     * @param id
     * @return
     */
    @PostMapping("/task/select/{id}")
    public Result TaskSelect(@PathVariable Integer id){
        TaskExamVM taskExamVM = taskExamService.TaskSelect(id);
        return Result.ok(taskExamVM);
    }

    /**
     * 根据id删除任务
     * @param id
     * @return
     */
    @PostMapping("/task/delete/{id}")
    public Result deleteTask(@PathVariable Integer id){
        String message = taskExamService.deleteTask(id);
        return Result.build(200, message);
    }

    @PostMapping("/task/select")
    public Result selectTask(){
        List<TaskExamVM> list = taskExamService.selectTask();
        return Result.ok(list);
    }
}
