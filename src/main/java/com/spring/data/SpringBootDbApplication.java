package com.spring.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 这是一个spring boot和jdbc整合的入门小程序
 * 数据源为druid
 */
@SpringBootApplication
public class SpringBootDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDbApplication.class, args);
    }
}
