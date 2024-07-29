package com.camellia.zoj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.camellia.zoj.mapper")
public class ZojApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZojApplication.class, args);
    }

}
