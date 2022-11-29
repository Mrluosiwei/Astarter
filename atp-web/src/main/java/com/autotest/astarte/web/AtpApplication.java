package com.autotest.astarte.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.autotest.astarte.web.mapper")
@SpringBootApplication
public class AtpApplication {
    public static void main(String[] args) {
        SpringApplication.run(AtpApplication.class);
    }
}
