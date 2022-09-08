package com.xyxy.kst.cax;

import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.service.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/14/10:28
 */
//@SpringBootTest
//public class ServiceAdmin8001Test {
//
//
//    @Autowired
//    private RedisCache redisCache;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @Test
//    public void test01(){
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        LoginUser loginUser = tokenService.getLoginUser(requestAttributes.getRequest());
//        System.out.println(loginUser.getUsername());
//
//    }
//}
