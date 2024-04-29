package com.example.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;

@Configuration
public class ServiceConfig {
    @Bean
    public String datePattern(){
        return "yyyy-MM-dd'T'HH:mm:ss.XXX";
    }
    @Bean
    public DateFormatter defaultDateFormatter(){
        return new DateFormatter(datePattern());
    }
}
