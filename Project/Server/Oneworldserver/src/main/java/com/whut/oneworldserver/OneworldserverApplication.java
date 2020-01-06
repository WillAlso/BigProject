package com.whut.oneworldserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.whut.oneworldserver.dao")
public class OneworldserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneworldserverApplication.class, args);
    }

}
