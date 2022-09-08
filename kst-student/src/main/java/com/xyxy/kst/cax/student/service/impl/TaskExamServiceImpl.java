package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xyxy.kst.cax.entity.ExamPaper;
import com.xyxy.kst.cax.entity.ExamPaperAnswer;
import com.xyxy.kst.cax.entity.TaskExam;
import com.xyxy.kst.cax.service.TaskExamService;
import com.xyxy.kst.cax.student.dao.TaskExamDao;
import com.xyxy.kst.cax.student.service.ExamPaperAnswerService;
import com.xyxy.kst.cax.student.service.ExamPaperService;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import com.xyxy.kst.cax.viewmodel.admin.task.TaskExamVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/7/17:07
 */
@Service
public class TaskExamServiceImpl extends ServiceImpl<TaskExamDao, TaskExam> implements TaskExamService {

    @Autowired
    private ExamPaperService examPaperService;

    @Autowired
    private ExamPaperAnswerService examPaperAnswerService;

    @Override
    public List<TaskExamVM> selectTaskAll(Integer level) {
        QueryWrapper<TaskExam> wrapper = new QueryWrapper<>();
        wrapper.eq("grade_level", level);
        List<TaskExam> taskExamList = baseMapper.selectList(wrapper);
        List<TaskExamVM> taskExamVMList = new ArrayList<>();
        for (TaskExam taskExam : taskExamList){
            List<ExamVM> paperItems = JsonUtil.toJsonListObject(taskExam.getTextContent(), ExamVM.class);
            TaskExamVM taskExamVM = JsonUtil.toJsonObject(JsonUtil.toJsonStr(taskExam), TaskExamVM.class);
            taskExamVM.setPaperItems(paperItems);
            taskExamVMList.add(taskExamVM);
        }
        return taskExamVMList;
    }
}
