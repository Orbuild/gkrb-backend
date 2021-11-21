package com.example.gkrb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.gkrb.mapper")
public class GkrbApplication {

    public static void main(String[] args) {
        SpringApplication.run(GkrbApplication.class, args);
    }

}
