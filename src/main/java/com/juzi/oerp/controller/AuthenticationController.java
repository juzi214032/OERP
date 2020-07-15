package com.juzi.oerp.controller;

import com.juzi.oerp.model.dto.UserLoginDTO;
import com.juzi.oerp.model.dto.UserRegistionDTO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.model.vo.UserLoginVO;
import com.juzi.oerp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseVO<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        UserLoginVO result = authenticationService.login(userLoginDTO);
        return new ResponseVO<>(result);
    }

    /**
     * 注册
     */
    @PostMapping("/registion")
    public ResponseVO<UserLoginVO> registion(UserRegistionDTO userRegistionDTO){
        UserLoginVO result = authenticationService.registion(userRegistionDTO);
        return new ResponseVO<>(result);
    }
}
