package com.xyxy.cax.auth.util.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})//注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
@Documented
public @interface OperLog {
    String operDesc() default "";  // 操作说明
}
