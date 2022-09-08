package com.xyxy.kst.cax.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/23/15:01
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedMethod("*"); // 允许所有请求头
        corsConfiguration.addAllowedOrigin("*"); // 允许所有请求方法，例如get，post等
        corsConfiguration.addAllowedHeader("*"); // 允许所有的请求来源
        corsConfiguration.setAllowCredentials(true); // 允许携带cookie

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", corsConfiguration); // 对所有经过网关的请求都生效
        return new CorsWebFilter(source);
    }
}
