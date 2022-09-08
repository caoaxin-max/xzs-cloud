package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.TaskExam;
import com.xyxy.kst.cax.viewmodel.admin.task.TaskExamVM;

import java.util.List;
import java.util.Map;

public interface TaskExamService extends IService<TaskExam> {

    /**
     * 分页条件查询任务
     * @param taskExamVM
     * @return
     */
    Map<String, Object> selectTaskExamPage(TaskExamVM taskExamVM);

    /**
     * 创建或者更新任务
     * @param taskExamVM
     * @return
     */
    String createOrUpdateTask(TaskExamVM taskExamVM);

    /**
     * 查询任务
     * @param id
     * @return
     */
    TaskExamVM TaskSelect(Integer id);

    String deleteTask(Integer id);

    /**
     * 查询任务
     * @return
     */
    List<TaskExamVM> selectTask();

}
