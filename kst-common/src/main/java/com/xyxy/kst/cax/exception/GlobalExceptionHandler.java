package com.xyxy.kst.cax.exception;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.result.SystemCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;

/**
 * @Author 曹阿鑫
 * @Date 2022/4/21/22:30
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // 当报Exception这个错时执行下面的方法
    @ResponseBody // 发送json数据给前端
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail();
    }


    @ExceptionHandler(YyghException.class) // 当报Exception这个错时执行下面的方法
    @ResponseBody // 发送json数据给前端
    public Result error(YyghException e){
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return Result.fail(SystemCode.AccessDenied);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result serviceException(ServiceException serviceException){
        String message = serviceException.getMessage();
        return Result.build(201, message);
    }

    @ExceptionHandler(NotRoleException.class)
    @ResponseBody
    public Result notRoleException(NotRoleException notRoleException){
        String message = notRoleException.getMessage();
        return Result.build(201, message);
    }

}
