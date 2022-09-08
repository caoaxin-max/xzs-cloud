package com.xyxy.kst.cax.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.entity.TaskExam;
import com.xyxy.kst.cax.viewmodel.admin.task.TaskExamVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskExamDao extends BaseMapper<TaskExam> {

    IPage<TaskExam> selectTaskExamPage(Page<TaskExam> page,@Param("taskExamVM") TaskExamVM taskExamVM);
}
