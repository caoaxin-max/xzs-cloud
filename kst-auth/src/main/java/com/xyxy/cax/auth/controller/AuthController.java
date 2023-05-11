package com.xyxy.cax.auth.controller;

import com.xyxy.cax.auth.service.AuthService;
import com.xyxy.cax.auth.util.annotation.OperLog;
import com.xyxy.kst.cax.domain.LoginBody;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.remote.RemoteStudentRegister;
import com.xyxy.kst.cax.remote.RemoteUserLogService;
import com.xyxy.kst.cax.remote.RemoteUserService;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.utils.JwtUtils;
import com.xyxy.kst.cax.utils.SecurityUtils;
import com.xyxy.kst.cax.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2022/8/16/16:23
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthService authService;

    @Autowired
    private RemoteStudentRegister remoteStudentRegister;

    @Autowired
    private RemoteUserLogService remoteUserLogService;

    @Autowired
    private RemoteUserService remoteUserService;
    /**
     * 登录验证
     * @param loginBody
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginBody loginBody){
        LoginUser userInfo = authService.login(loginBody.getUserName(), loginBody.getPassword());
        User user = remoteUserService.getUserByUserName(loginBody.getUserName());
        UserEventLog userEventLog = new UserEventLog(user.getId(), loginBody.getUserName(), user.getRealName(),user.getUserName()+"登录了考试系统" , new Date());
        this.saveUserLog(userEventLog);
        return Result.ok(tokenService.createToken(userInfo));
    }

    @PostMapping("/register")
    public Result registered(@RequestBody User user){
        Result result = remoteStudentRegister.userRegister(user);
        return result;
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request){
        String token = SecurityUtils.getToken(request);
        if (StringUtils.isNotEmpty(token)){
            String username = JwtUtils.getUserName(token);
            User user = remoteUserService.getUserByUserName(username);
            UserEventLog userEventLog = new UserEventLog(user.getId(), user.getUserName(), user.getRealName(),username+"退出了考试系统" , new Date());
            this.saveUserLog(userEventLog);
            // 删除用户缓存记录
            tokenService.delLoginUser(token);
        }
        return Result.ok();
    }


    private void saveUserLog(UserEventLog userEventLog){
        remoteUserLogService.saveUserEventLog(userEventLog);
    }
}
