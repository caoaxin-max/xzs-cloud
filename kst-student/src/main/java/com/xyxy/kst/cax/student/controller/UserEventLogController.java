package com.xyxy.kst.cax.student.controller;

import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.UserEventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/8/8:44
 */
@RestController
@RequestMapping("/api/student")
public class UserEventLogController {

    @Autowired
    private UserEventLogService userEventLogService;

    /**
     * 获取日志
     * @return
     */
    @PostMapping("/user/log")
    public Result getUserEvent(){
        List<UserEventLog> userEventLogs = userEventLogService.getUserEvent();
        return Result.ok(userEventLogs);
    }
}
