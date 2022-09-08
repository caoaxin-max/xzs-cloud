package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.TaskExamDao;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.*;
import com.xyxy.kst.cax.service.*;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import com.xyxy.kst.cax.viewmodel.admin.task.TaskExamVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/22/19:50
 */
@Service
public class TaskExamServiceImpl extends ServiceImpl<TaskExamDao, TaskExam> implements TaskExamService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserEventLogService userEventLogService;

    @Autowired
    private ExamPaperService examPaperService;

    @Autowired
    private ExamPaperAnswerService examPaperAnswerService;

    @Autowired
    private ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService;

    /**
     * 分页条件查询任务
     * @param taskExamVM
     * @return
     */
    @Override
    public Map<String, Object> selectTaskExamPage(TaskExamVM taskExamVM) {
        Page<TaskExam> page = new Page<>(taskExamVM.getPageIndex(), taskExamVM.getPageSize());
        IPage<TaskExam> taskExamIPage = baseMapper.selectTaskExamPage(page, taskExamVM);
        List<TaskExam> list = taskExamIPage.getRecords();
        long pageNum = taskExamIPage.getCurrent();
        long total = taskExamIPage.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("pageNum", pageNum);
        map.put("total", total);
        return map;
    }

    /**
     * 创建或者更新任务
     * @param taskExamVM
     * @return
     */
    @Override
    public String createOrUpdateTask(TaskExamVM taskExamVM) {
        TaskExam taskExam = baseMapper.selectById(taskExamVM.getId());
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        User user = userService.getUserByUserName(loginUser.getUsername());
        if (taskExam == null) {
            String toJsonStr = JsonUtil.toJsonStr(taskExamVM);
            TaskExam taskExam1 = JsonUtil.toJsonObject(toJsonStr, TaskExam.class);
            taskExam1.setCreateTime(new Date());
            taskExam1.setCreateUser(loginUser.getUsername());
            taskExam1.setTextContent(JsonUtil.toJsonStr(taskExamVM.getPaperItems()));
            UserEventLog userEventLog = new UserEventLog();
            userEventLog.setUserId(user.getId());
            userEventLog.setUserName(user.getUserName());
            userEventLog.setRealName(user.getRealName());
            userEventLog.setCreateTime(new Date());
            userEventLog.setContent(user.getUserName()+"创建一个个任务为"+taskExam1.getTitle());
            userEventLogService.saveUserEventLog(userEventLog);
            int insert = baseMapper.insert(taskExam1);
            if (insert > 0){
                List<ExamVM> paperItems = taskExamVM.getPaperItems();
                for (ExamVM examVM : paperItems){
                    ExamPaper examPaper = examPaperService.getById(examVM.getId());
                    if (examPaper != null && examPaper.getPaperType() == 6){
                        examPaper.setTaskExamId(taskExam1.getId());
                        examPaperService.updateById(examPaper);
                    }
                }
            }
            return "创建任务成功";
        }else {
            taskExam.setGradeLevel(taskExamVM.getGradeLevel());
            taskExam.setTitle(taskExamVM.getTitle());
            taskExam.setTextContent(JsonUtil.toJsonStr(taskExamVM.getPaperItems()));
            UserEventLog userEventLog = new UserEventLog();
            userEventLog.setUserId(user.getId());
            userEventLog.setUserName(user.getUserName());
            userEventLog.setRealName(user.getRealName());
            userEventLog.setCreateTime(new Date());
            userEventLog.setContent(user.getUserName()+"修改了任务"+taskExam.getTitle());
            userEventLogService.saveUserEventLog(userEventLog);
            baseMapper.updateById(taskExam);
            return "修改任务成功";
        }
    }

    /**
     * 查询任务
     * @param id
     * @return
     */
    @Override
    public TaskExamVM TaskSelect(Integer id) {
        TaskExam taskExam = baseMapper.selectById(id);
        List<ExamVM> paperItems = JsonUtil.toJsonListObject(taskExam.getTextContent(), ExamVM.class);
        TaskExamVM taskExamVM = JsonUtil.toJsonObject(JsonUtil.toJsonStr(taskExam), TaskExamVM.class);
        taskExamVM.setPaperItems(paperItems);
        return taskExamVM;
    }

    /**
     * 删除任务
     * @param id
     * @return
     */
    @Transactional
    @Override
    public String deleteTask(Integer id) {
        TaskExam taskExam = baseMapper.selectById(id);
        if (taskExam != null){
            QueryWrapper<ExamPaper> wrapper = new QueryWrapper<>();
            wrapper.eq("task_exam_id", id);
            ExamPaper examPaper = examPaperService.getOne(wrapper);
            LambdaUpdateWrapper<ExamPaper> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
            lambdaUpdateWrapper.set(ExamPaper::getTaskExamId, null);
            lambdaUpdateWrapper.eq(ExamPaper::getId, examPaper.getId());
            examPaperService.update(lambdaUpdateWrapper);
            QueryWrapper<ExamPaperAnswer> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("task_exam_id", id);
            ExamPaperAnswer examPaperAnswer = examPaperAnswerService.getOne(queryWrapper);
            if (examPaperAnswer!=null){
                examPaperAnswerService.remove(queryWrapper);
            }
            baseMapper.deleteById(id);
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @Override
    public List<TaskExamVM> selectTask() {
        List<TaskExam> taskExamList = baseMapper.selectList(null);
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
