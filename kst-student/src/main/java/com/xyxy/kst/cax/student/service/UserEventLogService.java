package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.UserEventLog;

import java.util.List;

public interface UserEventLogService extends IService<UserEventLog> {

    /**
     * 存储日志
     * @param userEventLog
     */
    void saveUserEventLog(UserEventLog userEventLog);

    /**
     * 获取日志
     * @return
     */
    List<UserEventLog> getUserEvent();

}
