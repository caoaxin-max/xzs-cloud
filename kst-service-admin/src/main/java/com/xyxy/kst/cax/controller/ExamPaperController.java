package com.xyxy.kst.cax.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.ExamPaper;
import com.xyxy.kst.cax.entity.Question;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.ExamPaperService;
import com.xyxy.kst.cax.service.QuestionService;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.utils.DateTimeUtil;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamPaperTitleItemVM;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import com.xyxy.kst.cax.viewmodel.admin.question.QuestionEditRequestVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TokenService tokenService;

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


   @PostMapping("/exam/paper/ga/{difficulty}/{subject}/{grade}/{numQuestions}/{username}")
    public Result gaExamPaper(@PathVariable("difficulty") int difficult,
                              @PathVariable("subject") int subject,
                              @PathVariable("grade") int grade,
                              @PathVariable("numQuestions") int numQuestions,
                              @PathVariable("username") String username
                              ){
       List<Question> questions = examPaperService.generatePaper(difficult, numQuestions, subject, grade);
       if (questions.isEmpty()){
           return Result.fail(505, "生成试卷失败，题目数量不够");
       } else {
           List<QuestionEditRequestVM> questionEditRequestVMS1 = new ArrayList<>();
           List<QuestionEditRequestVM> questionEditRequestVMS2 = new ArrayList<>();
           List<QuestionEditRequestVM> questionEditRequestVMS3 = new ArrayList<>();
           List<QuestionEditRequestVM> questionEditRequestVMS4 = new ArrayList<>();
           List<QuestionEditRequestVM> questionEditRequestVMS5 = new ArrayList<>();
           List<ExamPaperTitleItemVM> examPaperTitleItemVMS = new ArrayList<>();
           int count = 0;
           for (Question question : questions) {
               String textContent = question.getTextContent();
               QuestionEditRequestVM questionEditRequestVM = JsonUtil.toJsonObject(textContent, QuestionEditRequestVM.class);
               questionEditRequestVM.setId(question.getId());
               questionEditRequestVM.setQuestionType(question.getQuestionType());
               questionEditRequestVM.setGradeLevel(question.getGradeLevel());
               questionEditRequestVM.setSubjectId(question.getSubjectId());
               questionEditRequestVM.setScore(question.getScore());
               questionEditRequestVM.setDifficult(question.getDifficult());
               questionEditRequestVM.setCreateUser(username);
               switch (question.getQuestionType()){
                   case 1:
                       count += question.getScore();
                       questionEditRequestVM.setCorrect(question.getCorrect());
                       questionEditRequestVMS1.add(questionEditRequestVM);
                       break;
                   case 2:
                       count += question.getScore();
                       List<String> strings = JsonUtil.toJsonListObject(question.getCorrect(), String.class);
                       questionEditRequestVM.setCorrectArray(strings);
                       questionEditRequestVMS2.add(questionEditRequestVM);
                       break;
                   case 3:
                       count += question.getScore();
                       questionEditRequestVM.setCorrect(question.getCorrect());
                       questionEditRequestVMS3.add(questionEditRequestVM);
                       break;
                   case 4:
                       count += question.getScore();
                       questionEditRequestVM.setCorrect(question.getCorrect());
                       questionEditRequestVMS4.add(questionEditRequestVM);
                       break;
                   case 5:
                       count += question.getScore();
                       questionEditRequestVM.setCorrect(question.getCorrect());
                       questionEditRequestVMS5.add(questionEditRequestVM);
                       break;
               }
           }
           if (!questionEditRequestVMS1.isEmpty()){
               ExamPaperTitleItemVM examPaperTitleItemVM = new ExamPaperTitleItemVM();
               examPaperTitleItemVM.setName("单选题");
               examPaperTitleItemVM.setQuestionItems(questionEditRequestVMS1);
               examPaperTitleItemVMS.add(examPaperTitleItemVM);
           }
           if (!questionEditRequestVMS2.isEmpty()) {
               ExamPaperTitleItemVM examPaperTitleItemVM = new ExamPaperTitleItemVM();
               examPaperTitleItemVM.setName("多选题");
               examPaperTitleItemVM.setQuestionItems(questionEditRequestVMS2);
               examPaperTitleItemVMS.add(examPaperTitleItemVM);
           }
           if (!questionEditRequestVMS3.isEmpty()) {
               ExamPaperTitleItemVM examPaperTitleItemVM = new ExamPaperTitleItemVM();
               examPaperTitleItemVM.setName("判断题");
               examPaperTitleItemVM.setQuestionItems(questionEditRequestVMS3);
               examPaperTitleItemVMS.add(examPaperTitleItemVM);
           }
           if (!questionEditRequestVMS4.isEmpty()) {
               ExamPaperTitleItemVM examPaperTitleItemVM = new ExamPaperTitleItemVM();
               examPaperTitleItemVM.setName("填空题");
               examPaperTitleItemVM.setQuestionItems(questionEditRequestVMS4);
               examPaperTitleItemVMS.add(examPaperTitleItemVM);
           }
           if (!questionEditRequestVMS5.isEmpty()){
               ExamPaperTitleItemVM examPaperTitleItemVM = new ExamPaperTitleItemVM();
               examPaperTitleItemVM.setName("简答题");
               examPaperTitleItemVM.setQuestionItems(questionEditRequestVMS5);
               examPaperTitleItemVMS.add(examPaperTitleItemVM);
           }
           ExamPaper examPaper = new ExamPaper();
           examPaper.setTextContent(JsonUtil.toJsonStr(examPaperTitleItemVMS));
           examPaper.setSubjectId(subject);
           examPaper.setGradeLevel(grade);
           examPaper.setPaperType(1);
           examPaper.setScore(count);
           examPaper.setQuestionCount(numQuestions);
           examPaper.setCreateTime(new Date());
           examPaper.setSuggestTime(questions.size()*5);
           examPaper.setCreateUser(username);
           int i = 1;
           String name;
           while (true){
               name = String.format("智能组卷-%d", i);
               boolean checkUnique = checkUnique(name);
               if (checkUnique){
                   i++;
               }else {
                   examPaper.setName(name);
                   break;
               }
           }
           examPaperService.save(examPaper);
           return Result.build(200, "已生成试卷："+name);
       }
   }

   private boolean checkUnique(String name){
       QueryWrapper<ExamPaper> query = new QueryWrapper<>();
       query.eq("name", name);
       ExamPaper examPaper = examPaperService.getOne(query);
       if (examPaper==null){
           return false;
       }else {
           return true;
       }
   }
}
