package com.xyxy.kst.cax.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/6/14:50
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.xyxy")
@EnableFeignClients(basePackages = "com.xyxy")
public class StudentApplication9003 {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication9003.class, args);
    }
}
