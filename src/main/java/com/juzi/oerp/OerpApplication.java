package com.juzi.oerp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juzi
 */
@RestController
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.juzi.oerp.dao")
public class OerpApplication {

    public static void main(String[] args) {
        SpringApplication.run(OerpApplication.class, args);
    }

    @GetMapping(produces = "text/html;charset=utf-8")
    public String index() {
        return "<style type=\"text/css\">*{ padding: 0; margin: 0; } div{ padding: 4px 48px;} a{color:#2E5CD5;cursor:" +
                "pointer;text-decoration: none} a:hover{text-decoration:underline; } body{ background: #fff; font-family:" +
                "\"Century Gothic\",\"Microsoft yahei\"; color: #333;font-size:18px;} h1{ font-size: 100px; font-weight: normal;" +
                "margin-bottom: 12px; } p{ line-height: 1.6em; font-size: 42px }</style><div style=\"padding: 24px 48px;\"><p align='center'>" +
                "<span style=\"font-size:30px\">OERP 在线考试报名系统</span></p></div> ";
    }
}
