package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.ExamPaperDao;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.*;
import com.xyxy.kst.cax.service.*;
import com.xyxy.kst.cax.utils.DateTimeUtil;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamPaperTitleItemVM;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import com.xyxy.kst.cax.viewmodel.admin.question.QuestionEditRequestVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/20:31
 */
@Service
public class ExamPaperServiceImpl extends ServiceImpl<ExamPaperDao, ExamPaper> implements ExamPaperService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserEventLogService userEventLogService;

    @Autowired
    private ExamPaperAnswerService examPaperAnswerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TaskExamService taskExamService;

    /**
     * 获取到试卷卷总数
     */
    @Override
    public Integer getExamPaperCount(){
        Integer examPaperCount = baseMapper.selectCount(null);
        return examPaperCount;
    }

    /**
     * 分页条件查询
     * @param page
     * @param examVM
     * @return
     */
    @Override
    public Map<String, Object> getExamPaperPage(Page<ExamPaper> page, ExamVM examVM) {
        IPage<ExamPaper> examPaperPage = baseMapper.getExamPaperPage(page, examVM);
        List<ExamPaper> examPaperList = examPaperPage.getRecords();
        long total = examPaperPage.getTotal();
        long pageNum = examPaperPage.getCurrent();
        Map<String, Object> map = new HashMap<>();
        map.put("list", examPaperList);
        map.put("total", total);
        map.put("pageNum", pageNum);
        return map;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public ExamPaper selectExamPaper(Integer id) {
        ExamPaper examPaper = baseMapper.selectById(id);
        return examPaper;
    }

    /**
     * 添加或者修改考试试卷
     * @param examVM
     * @return
     */
    @Transactional
    @Override
    public String createOrUpdateExamPaper(ExamVM examVM) {
//        System.out.println("**************************");
        String jsonStr = JsonUtil.toJsonStr(examVM);
        ExamPaper examPaper1 = JsonUtil.toJsonObject(jsonStr, ExamPaper.class);
        examPaper1.setGradeLevel(examVM.getLevel());
//        System.out.println("=====================>"+examVM.getLimitDateTime().toString());
        if (examVM.getPaperType() == 4){
            examPaper1.setLimitStartTime(DateTimeUtil.parse(examVM.getLimitDateTime().get(0), "yyyy-MM-dd HH:mm:ss"));
            examPaper1.setLimitEndTime(DateTimeUtil.parse(examVM.getLimitDateTime().get(1), "yyyy-MM-dd HH:mm:ss"));
        }
        examPaper1.setTextContent(JsonUtil.toJsonStr(examVM.getTitleItems()));
        ExamPaper examPaper = baseMapper.selectById(examVM.getId());
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        // 计算试卷的总分数，以及改试卷的题目数量
        List<ExamPaperTitleItemVM> titleItems = examVM.getTitleItems();
        int sumScores = 0;
        int count = 0;
        for (ExamPaperTitleItemVM titleItem : titleItems) {
            List<QuestionEditRequestVM> questionItems = titleItem.getQuestionItems();
            for (QuestionEditRequestVM questionEditRequestVM : questionItems){
                Question question = questionService.getById(questionEditRequestVM.getId());
                sumScores += question.getScore();
                count++;
            }
        }
        examPaper1.setScore(sumScores);
        examPaper1.setQuestionCount(count);
        if (examPaper == null){
            examPaper1.setCreateTime(new Date());
            examPaper1.setCreateUser(loginUser.getUsername());
            User user = userService.getUserByUserName(loginUser.getUsername());
            UserEventLog userEventLog = new UserEventLog();
            userEventLog.setUserId(user.getId());
            userEventLog.setUserName(user.getUserName());
            userEventLog.setRealName(user.getRealName());
            userEventLog.setCreateTime(new Date());
            switch (examVM.getPaperType()){
                case 1 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个固定试卷,试卷名称:"+examVM.getName());
                    break;
                case 4 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个时段试卷,试卷名称:"+examVM.getName());
                    break;
                case 6 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个任务试卷,试卷名称:"+examVM.getName());
                    break;
            }
            userEventLogService.saveUserEventLog(userEventLog);
            int insert = baseMapper.insert(examPaper1);
            return "添加试卷成功";
        }else {
            User user = userService.getUserByUserName(loginUser.getUsername());
            int update = baseMapper.updateById(examPaper1);
            if (update>0){
                UserEventLog userEventLog = new UserEventLog();
                userEventLog.setUserId(user.getId());
                userEventLog.setUserName(user.getUserName());
                userEventLog.setRealName(user.getRealName());
                userEventLog.setCreateTime(new Date());
                userEventLog.setContent(user.getUserName()+"更新了"+examVM.getName()+"试卷");
                userEventLogService.saveUserEventLog(userEventLog);
                if (examPaper1.getTaskExamId() != null){
                    TaskExam taskExam = taskExamService.getById(examPaper1.getTaskExamId());
                    List<ExamPaperTitleItemVM> ExamPaperTitleItemVMs = JsonUtil.toJsonListObject(examPaper1.getTextContent(), ExamPaperTitleItemVM.class);
                    List<ExamVM> examVMS = JsonUtil.toJsonListObject(taskExam.getTextContent(), ExamVM.class);
                    for (ExamVM examVM1 : examVMS){
                        if (examVM1.getId() == examPaper1.getId()){
                            examVM1.setTitleItems(ExamPaperTitleItemVMs);
                        }
                    }
                    String jsonStr1 = JsonUtil.toJsonStr(examVMS);
                    LambdaUpdateWrapper<TaskExam> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
                    lambdaUpdateWrapper.set(TaskExam::getTextContent, jsonStr1);
                    lambdaUpdateWrapper.eq(TaskExam::getId, examPaper1.getTaskExamId());
                    taskExamService.update(lambdaUpdateWrapper);
                }
            }
            return "修改试卷成功";
        }
    }

    /**
     * 更新状态
     * @param id
     * @return
     */
    @Override
    public String changeStatus(Integer id) {
        ExamPaper examPaper = baseMapper.selectById(id);
        if (examPaper != null){
            Integer status = examPaper.getStatus() == 1 ? 2 : 1;
            examPaper.setStatus(status);
            baseMapper.updateById(examPaper);
            return "编辑成功";
        }else {
            return "编辑失败";
        }
    }

    /**
     * 删除试卷
     * @param id
     * @return
     */
    @Override
    public String deletePaper(Integer id) {
        ExamPaper examPaper = baseMapper.selectById(id);
        if (examPaper != null) {
            if (examPaper.getTaskExamId() != null){
                return "该试卷已在任务中，不可以删除";
            }else {
                baseMapper.deleteById(id);
                return "删除成功";
            }
        }else {
            return "删除失败";
        }
    }

    @Override
    public Map<String, Object> taskExamPage(ExamVM examVM) {
        Page<ExamPaper> page = new Page<>(examVM.getPageIndex(), examVM.getPageSize());
        IPage<ExamPaper> examPagePage = baseMapper.taskExamPage(page, examVM);
        List<ExamPaper> list = examPagePage.getRecords();
        List<ExamVM> examVMS = new ArrayList<>();
        
        for (ExamPaper examPaper : list){
            ExamVM examVM1 = new ExamVM();
            examVM1.setLevel(examPaper.getGradeLevel());
            List<ExamPaperTitleItemVM> titleItems = JsonUtil.toJsonListObject(examPaper.getTextContent(), ExamPaperTitleItemVM.class);
            examVM1.setTitleItems(titleItems);
            examVM1.setSubjectId(examPaper.getSubjectId());
            examVM1.setPaperType(examPaper.getPaperType());
            examVM1.setSuggestTime(examPaper.getSuggestTime());
            examVM1.setName(examPaper.getName());
            List<String> dates = new ArrayList<>();
            dates.add(DateTimeUtil.dateFormat(examPaper.getLimitStartTime()));
            dates.add(DateTimeUtil.dateFormat(examPaper.getLimitEndTime()));
            examVM1.setLimitDateTime(dates);
            examVM1.setId(examPaper.getId());
            examVMS.add(examVM1);
        }
        long pageNum = examPagePage.getCurrent();
        long total = examPagePage.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("list", examVMS);
        map.put("pageNum", pageNum);
        map.put("total", total);
        return map;
    }
}
