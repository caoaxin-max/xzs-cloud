package com.xyxy.kst.cax.controller;

import com.xyxy.kst.cax.entity.Question;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.QuestionService;
import com.xyxy.kst.cax.viewmodel.admin.question.QuestionEditRequestVM;
import com.xyxy.kst.cax.viewmodel.admin.usermodel.PageAndSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/21/10:47
 */
@RestController
@RequestMapping("/api/admin")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * 分页条件查询
     * @param pageAndSearch
     * @return
     */
    @PostMapping("/question/page")
    public Result getQuestionPage(@RequestBody PageAndSearch pageAndSearch){
        Map<String, Object> questionPageMap = questionService.getQuestionPage(pageAndSearch);
        return Result.ok(questionPageMap);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @PostMapping("/question/select/{id}")
    public Result selectQuestionById(@PathVariable Integer id){
        QuestionEditRequestVM question = questionService.selectQuestionById(id);
        return Result.ok(question);
    }

    /**
     * 修改和创建题目
     * @param questionEditRequestVM
     * @return
     */
    @PostMapping("/question/edit")
    public Result createOrUpdateQuestion(@RequestBody QuestionEditRequestVM questionEditRequestVM){
        String message = questionService.createOrUpdateQuestion(questionEditRequestVM);
        return Result.build(200, message);
    }

    @PostMapping("/question/delete/{id}")
    public Result deleteQuestion(@PathVariable Integer id){
        String message = questionService.deleteQuestion(id);
        return Result.build(200, message);
    }
}
