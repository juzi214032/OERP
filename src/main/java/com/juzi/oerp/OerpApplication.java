package com.juzi.oerp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Juzi
 */
@SpringBootApplication
@MapperScan("com.juzi.oerp.dao")
public class OerpApplication {

    public static void main(String[] args) {
        SpringApplication.run(OerpApplication.class, args);
    }

}
