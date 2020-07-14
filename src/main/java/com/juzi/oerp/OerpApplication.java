package com.juzi.oerp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Juzi
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.juzi.oerp.dao")
public class OerpApplication {

    public static void main(String[] args) {
        SpringApplication.run(OerpApplication.class, args);
    }

}
