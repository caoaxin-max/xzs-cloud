package com.xyxy.kst.cax;

import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/17:15
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class GatewayApplication82 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication82.class, args);
    }
}
