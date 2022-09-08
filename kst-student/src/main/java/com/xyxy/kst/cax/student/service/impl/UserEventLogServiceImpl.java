package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.service.UserEventLogService;
import com.xyxy.kst.cax.student.dao.UserEventLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/7/17:24
 */
@Service
public class UserEventLogServiceImpl extends ServiceImpl<UserEventLogDao, UserEventLog> implements UserEventLogService {
    @Autowired
    private TokenService tokenService;
    /**
     * 存储日志
     * @param userEventLog
     */
    @Override
    public void saveUserEventLog(UserEventLog userEventLog) {
        baseMapper.insert(userEventLog);
    }

    /**
     * 获取日志
     * @return
     */
    @Override
    public List<UserEventLog> getUserEvent() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        List<UserEventLog> userEventLogs = baseMapper.selectUserEventDay(loginUser.getUsername());
        return userEventLogs;
    }
}
