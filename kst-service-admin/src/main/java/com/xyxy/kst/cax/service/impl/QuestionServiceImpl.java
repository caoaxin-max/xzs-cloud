package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.QuestionDao;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.Question;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.service.QuestionService;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.service.UserEventLogService;
import com.xyxy.kst.cax.service.UserService;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.question.QuestionEditItemVM;
import com.xyxy.kst.cax.viewmodel.admin.question.QuestionEditRequestVM;
import com.xyxy.kst.cax.viewmodel.admin.usermodel.PageAndSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/25/17:12
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionDao, Question> implements QuestionService
{

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserEventLogService userEventLogService;


    /**
     * 获取题目总数
     */
    @Override
    public Integer getQuestionCount() {
        QueryWrapper<Question> wrapper = new QueryWrapper<>();
        Integer questionCount = baseMapper.selectCount(wrapper);
        return questionCount;
    }

    /**
     * 分页条件查询
     * @param pageAndSearch
     * @return
     */
    @Override
    public Map<String, Object> getQuestionPage(PageAndSearch pageAndSearch) {
        if (pageAndSearch.getQuestionType() == "") {
            pageAndSearch.setQuestionType(null);
        }
        Page<Question> page = new Page<>(pageAndSearch.getPageIndex(), pageAndSearch.getPageSize());
        IPage<Question> questionPage = baseMapper.getQuestionPage(page, pageAndSearch);
        List<Question> list = questionPage.getRecords();
        for (Question question : list) {
            String textContent = question.getTextContent();
            QuestionEditRequestVM questionEditRequestVM = JsonUtil.toJsonObject(textContent, QuestionEditRequestVM.class);
            question.setShortTitle(questionEditRequestVM.getTitle());
        }
        long total = questionPage.getTotal();
        long pageNum = questionPage.getCurrent();
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", total);
        map.put("pageNum", pageNum);
        return map;
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public QuestionEditRequestVM selectQuestionById(Integer id) {
        Question question = baseMapper.selectById(id);
        String content = question.getTextContent();
        QuestionEditRequestVM questionEditRequestVM = JsonUtil.toJsonObject(content, QuestionEditRequestVM.class);
        questionEditRequestVM.setId(question.getId());
        questionEditRequestVM.setQuestionType(question.getQuestionType());
        questionEditRequestVM.setGradeLevel(question.getGradeLevel());
        questionEditRequestVM.setSubjectId(question.getSubjectId());
        questionEditRequestVM.setScore(question.getScore());
        questionEditRequestVM.setDifficult(question.getDifficult());
        if (question.getQuestionType() == 2){
            List<String> correctArray = JsonUtil.toJsonListObject(question.getCorrect(), String.class);
            questionEditRequestVM.setCorrectArray(correctArray);
        }else {
            questionEditRequestVM.setCorrect(question.getCorrect());
        }
        return questionEditRequestVM;
    }

    /**
     * 创建或者更新题目
     * @param questionEditRequestVM
     * @return
     */
    @Transactional
    @Override
    public String createOrUpdateQuestion(QuestionEditRequestVM questionEditRequestVM) {
        String jsonStr = JsonUtil.toJsonStr(questionEditRequestVM);
        Question question1 = JsonUtil.toJsonObject(jsonStr, Question.class);
        if (questionEditRequestVM.getQuestionType() == 2){
            question1.setCorrect(JsonUtil.toJsonStr(questionEditRequestVM.getCorrectArray()));
        }
        Map<String, Object> map = new HashMap<>();
        String title = questionEditRequestVM.getTitle();
        List<QuestionEditItemVM> items = questionEditRequestVM.getItems();
        String analyze = questionEditRequestVM.getAnalyze();
        map.put("title", title);
        map.put("items", items);
        map.put("analyze", analyze);
        String toJsonStr = JsonUtil.toJsonStr(map);
        question1.setTextContent(toJsonStr);
        Question question = baseMapper.selectById(questionEditRequestVM.getId());
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (question == null){
            question1.setCreateTime(new Date());
            question1.setCreateUser(loginUser.getUsername());
            User user = userService.getUserByUserName(loginUser.getUsername());
            UserEventLog userEventLog = new UserEventLog();
            userEventLog.setUserId(user.getId());
            userEventLog.setUserName(user.getUserName());
            userEventLog.setRealName(user.getRealName());
            userEventLog.setCreateTime(new Date());
            switch (questionEditRequestVM.getQuestionType()){
                case 1 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个单选题,题干:"+title);
                    break;
                case 2 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个多选题,题干:"+title);
                    break;
                case 3 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个判断题,题干:"+title);
                    break;
                case 4 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个填空题,题干:"+title);
                    break;
                case 5 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个简答题,题干:"+title);
                    break;
                default :
                    break;
            }
            userEventLogService.saveUserEventLog(userEventLog);
            baseMapper.insert(question1);
            return "添加题目成功";
        }else {
            User user = userService.getUserByUserName(loginUser.getUsername());

            int update = baseMapper.updateById(question1);
            if (update>0){
                UserEventLog userEventLog = new UserEventLog();
                userEventLog.setUserId(user.getId());
                userEventLog.setUserName(user.getUserName());
                userEventLog.setRealName(user.getRealName());
                userEventLog.setCreateTime(new Date());
                userEventLog.setContent(loginUser.getUsername()+"更改了id为"+question.getId()+"题目");
                userEventLogService.saveUserEventLog(userEventLog);
            }
            return "修改题目成功";
        }
    }

    /**
     * 删除问题
     * @param id
     * @return
     */
    @Override
    public String deleteQuestion(Integer id) {
        Question question = baseMapper.selectById(id);
        int delete = baseMapper.deleteById(id);
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (delete > 0) {
            String createUser = question.getCreateUser();
            User user = userService.getUserByUserName(createUser);
            UserEventLog userEventLog = new UserEventLog();
            userEventLog.setUserId(user.getId());
            userEventLog.setUserName(user.getUserName());
            userEventLog.setRealName(user.getRealName());
            userEventLog.setCreateTime(new Date());
            userEventLog.setContent(loginUser.getUsername()+"用户删除题目，id为"+question.getId());
            userEventLogService.saveUserEventLog(userEventLog);
            return "删除成功";
        }else {
            return "删除失败";
        }
    }
}
