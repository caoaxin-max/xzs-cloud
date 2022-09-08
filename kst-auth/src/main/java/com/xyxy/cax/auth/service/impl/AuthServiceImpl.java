package com.xyxy.cax.auth.service.impl;

import com.xyxy.cax.auth.service.AuthService;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.exception.ServiceException;
import com.xyxy.kst.cax.remote.RemoteUserService;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.utils.SecurityUtils;
import com.xyxy.kst.cax.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;


/**
 * @Author 曹阿鑫
 * @Date 2022/8/16/17:27
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RemoteUserService remoteUserService;

    @Override
    public LoginUser login(String username, String password) {
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(username, password)) {
            throw new ServiceException("用户/密码必须填写");
        }
        User user = remoteUserService.getUserByUserName(username);
        if (StringUtils.isNull(user)){
            throw new ServiceException("登录用户：" + username + " 不存在");
        }
        if (user.getStatus().equals(2)){
            throw new ServiceException("对不起，您的账号：" + username + " 已停用");
        }
        if (!SecurityUtils.matchesPassword(password, user.getPassword())) {
            throw new ServiceException("用户不存在/密码错误");
        }
        Set<String> set = new HashSet<>();
        set.add(user.getRole()+"");
        LoginUser loginUser = new LoginUser();
        loginUser.setUserid(user.getId());
        loginUser.setUsername(username);
        loginUser.setUser(user);
        loginUser.setRoles(set);
        return loginUser;
    }
}
