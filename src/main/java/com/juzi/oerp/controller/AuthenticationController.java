package com.juzi.oerp.controller;

import com.juzi.oerp.model.dto.UserLoginDTO;
import com.juzi.oerp.model.dto.UserRegistionDTO;
import com.juzi.oerp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public void login(UserLoginDTO userLoginDTO){

    }

    /**
     * 注册
     */
    @PostMapping("/registion")
    public void registion(UserRegistionDTO userRegistionDTO){

    }
}
