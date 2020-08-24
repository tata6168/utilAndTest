package com.synthesize.test.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.synthesize.test.mybatis.mapper;")
public class MybatisStart {
    public static void main(String[] args) {
        SpringApplication.run(MybatisStart.class,args);
    }
}
