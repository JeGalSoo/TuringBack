package com.turing.api;

import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;

@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }
//
//
//    @Bean
//    JpaQueryFactory jpaQueryMethodFactory(EntityManager manager) {
//        return new JpaQueryMethodFactory(manager);
//    }

}