package com.wsy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();

        //允许客户端发送包含cookie的用户凭证
        configuration.setAllowCredentials(true);
        //允许所有请求头
        configuration.addAllowedHeader("*");
        //允许所有请求方法
        configuration.addAllowedMethod("*");
        //允许跨所有域
        configuration.addAllowedOrigin("*");

        source.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(source);
    }
}
