package com.xyxy.kst.cax.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.entity.ExamPaper;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.ExamPaperService;
import com.xyxy.kst.cax.utils.DateTimeUtil;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamPaperTitleItemVM;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/17/19:57
 */
@RestController
@RequestMapping("/api/admin")
public class ExamPaperController {
    @Autowired
    private ExamPaperService examPaperService;

    /**
     * 分页条件查询
     * @param examVM
     * @return
     */
    @PostMapping("/exam/paper/page")
    public Result getExamPaperPage(@RequestBody ExamVM examVM){
        Page<ExamPaper> page = new Page<>(examVM.getPageIndex(), examVM.getPageSize());
        Map<String, Object> map = examPaperService.getExamPaperPage(page, examVM);
        return Result.ok(map);
    }

    /**
     * 按id查询
     * @param id
     * @return
     */
    @PostMapping("/exam/paper/select/{id}")
    public Result selectExamPaper(@PathVariable Integer id){
        ExamPaper examPaper = examPaperService.selectExamPaper(id);
        ExamVM examVM = JsonUtil.toJsonObject(JsonUtil.toJsonStr(examPaper), ExamVM.class);
        examVM.setLevel(examPaper.getGradeLevel());
        List<String> limitDateTime = new ArrayList<>();
        limitDateTime.add(DateTimeUtil.dateFormat(examPaper.getLimitStartTime()));
        limitDateTime.add(DateTimeUtil.dateFormat(examPaper.getLimitEndTime()));
        examVM.setLimitDateTime(limitDateTime);
        String textContent = examPaper.getTextContent();
        List<ExamPaperTitleItemVM> items = JSON.parseArray(textContent, ExamPaperTitleItemVM.class);
        examVM.setTitleItems(items);
        return Result.ok(examVM);
    }

    /**
     * 写到了试卷创建和修改
     */
    @PostMapping("/exam/paper/edit")
    public Result createOrUpdateExamPaper(@RequestBody ExamVM examVM){
        String message = examPaperService.createOrUpdateExamPaper(examVM);
        return Result.build(200, message);
    }

    /**
     * 更新状态
     * @param id
     * @return
     */
    @PostMapping("/exam/paper/changeStatus/{id}")
    public Result changeStatus(@PathVariable Integer id){
        String message = examPaperService.changeStatus(id);
        return Result.build(200, message);
    }

    /**
     * 删除试卷
     * @param id
     * @return
     */
    @PostMapping("/exam/paper/delete/{id}")
    public Result deletePaper(@PathVariable Integer id){
        String message = examPaperService.deletePaper(id);
        return Result.build(200, message);
    }

    @PostMapping("/exam/paper/taskExamPage")
    public Result taskExamPage(@RequestBody ExamVM examVM){
        Map<String, Object> map = examPaperService.taskExamPage(examVM);
        return Result.ok(map);
    }
}
