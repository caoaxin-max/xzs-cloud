package com.xyxy.kst.cax.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.entity.Subject;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.SubjectService;
import com.xyxy.kst.cax.viewmodel.admin.usermodel.PageAndSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/17/15:28
 */
@RestController
@RequestMapping("/api/admin")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/education/subject/page")
    public Result getSubjectPageList(@RequestBody PageAndSearch pageAndSearch) {
        Page<Subject> page = new Page<>(pageAndSearch.getPageIndex(), pageAndSearch.getPageSize());
        IPage<Subject> subjectPage = subjectService.getSubjectPageList(page, pageAndSearch.getLevel());
        List<Subject> subjects = subjectPage.getRecords();
        long pageNum = subjectPage.getCurrent();
        long total = subjectPage.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("list", subjects);
        map.put("pageNum", pageNum);
        map.put("total", total);
        return Result.ok(map);
    }

    @PostMapping("/education/subject/delete/{id}")
    public Result deleteSubject(@PathVariable Integer id){
        Integer integer = subjectService.deleteSubject(id);
        if (integer>0){
            return Result.build(200, "删除成功");
        }
        return Result.fail();
    }

    @PostMapping("/education/subject/select/{id}")
    public Result selectByIdSubject(@PathVariable Integer id){
        Subject subject = subjectService.selectByIdSubject(id);
        return Result.ok(subject);
    }

    @PostMapping("/education/subject/edit")
    public Result createOrUpdateSubject(@RequestBody Subject subject){
        String message = subjectService.createOrUpdateSubject(subject);
        return Result.build(200, message);
    }

    /**
     * 查询所有的年级和学科
     * @return
     */
    @PostMapping("/education/subject/list")
    public Result getSubjectList(){
        List<Subject> subject = subjectService.getSubjectList();
        return Result.ok(subject);
    }
}
