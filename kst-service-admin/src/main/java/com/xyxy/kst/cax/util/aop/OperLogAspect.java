package com.xyxy.kst.cax.util.aop;

import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.service.UserEventLogService;
import com.xyxy.kst.cax.service.UserService;
import com.xyxy.kst.cax.util.annotation.OperLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2023/4/30/11:18
 */
@Aspect
@Component
public class OperLogAspect {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserEventLogService userEventLogService;
    @Autowired
    private UserService userService;

    @Pointcut("@annotation(com.xyxy.kst.cax.util.annotation.OperLog)")
    public void operLogPoinCut(){}

    /**
     * 正常返回通知，当该方法执行成功时调用该接口
     * @param joinPoint 切入点
     * @param keys 返回结果
     */
    @AfterReturning(value = "operLogPoinCut()", returning = "keys")
    public void saveOperlog(JoinPoint joinPoint, Object keys){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        String username = loginUser.getUsername();
        User user = userService.getUserByUserName(username);
        UserEventLog userEventLog = new UserEventLog();
        userEventLog.setUserId(user.getId());
        userEventLog.setUserName(user.getUserName());
        if (null != user.getRealName()) {
            userEventLog.setRealName(user.getRealName());
        }
        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取切入点所在的方法
        Method method = signature.getMethod();
        // 获取操作
        OperLog opLog = method.getAnnotation(OperLog.class);
        if (opLog != null){
            String operDesc = opLog.operDesc();
            userEventLog.setContent(operDesc); // 操作描述
        }
        userEventLog.setCreateTime(new Date());
        userEventLogService.saveUserEventLog(userEventLog);
    }
}
