package com.juzi.oerp.controller;

import com.juzi.oerp.model.dto.UserRegistionDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juzi
 * @date 2020/7/14 14:40
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    /**
     * 登录
     */
    @PostMapping("/login")
    public void login(){

    }

    /**
     * 注册
     */
    @PostMapping("/registion")
    public void registion(UserRegistionDTO userRegistionDTO){

    }
}
