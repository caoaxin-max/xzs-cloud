package com.xyxy.cax.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author 曹阿鑫
 * @Date 2022/8/16/17:17
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xyxy")
@ComponentScan(basePackages = "com.xyxy")
public class AuthApplication8500 {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication8500.class, args);
    }
}
