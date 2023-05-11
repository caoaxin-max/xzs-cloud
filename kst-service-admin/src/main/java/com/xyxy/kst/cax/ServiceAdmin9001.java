package com.xyxy.kst.cax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/20:07
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.xyxy")
@EnableFeignClients(basePackages = "com.xyxy")
@EnableAspectJAutoProxy
public class ServiceAdmin9001 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdmin9001.class, args);
    }
}
