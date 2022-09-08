package com.xyxy.kst.cax.student.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/8/15:08
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/updateImages/**")
                .addResourceLocations("file:E:\\毕业设计\\xzs-cloud\\kst-student\\src\\main\\resources\\updateImages\\");
    }
}
