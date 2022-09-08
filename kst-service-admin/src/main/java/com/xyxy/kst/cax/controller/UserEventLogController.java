package com.xyxy.kst.cax.controller;

import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.UserEventLogService;
import com.xyxy.kst.cax.viewmodel.admin.usermodel.PageAndSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/26/14:31
 */
@RestController
@RequestMapping("/api/admin")
public class UserEventLogController {

    @Autowired
    private UserEventLogService userEventLogService;

    /**
     * 保存日志
     * @param userEventLog
     */
    @PostMapping("/saveUserEventLog")
    public void saveUserEventLog(@RequestBody UserEventLog userEventLog){
        userEventLogService.saveUserEventLog(userEventLog);
    }


    @PostMapping("/user/event/page/list")
    public Result getUserEventPageList(@RequestBody PageAndSearch pageAndSearch){
        Map<String, Object> map = userEventLogService.getUserEventPage(pageAndSearch);
        return Result.ok(map);
    }
}
