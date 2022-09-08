package com.xyxy.cax.auth.service;

import com.xyxy.kst.cax.domain.LoginUser;

public interface AuthService {
    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    LoginUser login(String username, String password);


}
