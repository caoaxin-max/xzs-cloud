package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.TaskExam;
import com.xyxy.kst.cax.viewmodel.admin.task.TaskExamVM;

import java.util.List;

public interface TaskExamService extends IService<TaskExam> {

    /**
     * 查询所有的任务
     * @return
     */
    List<TaskExamVM> selectTaskAll(Integer level);

}
