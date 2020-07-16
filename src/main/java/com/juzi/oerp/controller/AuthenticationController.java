package com.juzi.oerp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.juzi.oerp.model.dto.SMSCaptchaParamDTO;
import com.juzi.oerp.model.dto.UserLoginDTO;
import com.juzi.oerp.model.dto.UserRegistionDTO;
import com.juzi.oerp.model.vo.CaptchaVO;
import com.juzi.oerp.model.vo.UserLoginVO;
import com.juzi.oerp.model.vo.response.CreateResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 用户登录
     */
    @PostMapping("/login")
    public ResponseVO<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        UserLoginVO result = authenticationService.login(userLoginDTO);
        return new ResponseVO<>(result);
    }

    /**
     * 用户注册
     */
    @PostMapping("/registion")
    public ResponseVO<UserLoginVO> registion(UserRegistionDTO userRegistionDTO) {
        UserLoginVO result = authenticationService.registion(userRegistionDTO);
        return new ResponseVO<>(result);
    }

    /**
     * 获取图片验证码
     *
     * @return 图片验证码信息
     */
    @GetMapping("/captcha/image")
    public ResponseVO<CaptchaVO> getImageCaptcha() {
        CaptchaVO captcha = authenticationService.getImageCaptcha();
        return new ResponseVO<>(captcha);
    }

    /**
     * 获取短信验证码
     * @param smsCaptchaParamDTO 短信验证码参数
     * @return 发送成功信息
     * @throws JsonProcessingException 发送短信验证码时转换 JSON 异常
     */
    @GetMapping("/captcha/sms")
    public ResponseVO<Object> getSMSCaptcha(@RequestBody SMSCaptchaParamDTO smsCaptchaParamDTO) throws JsonProcessingException {
        authenticationService.getSMSCaptcha(smsCaptchaParamDTO);
        return new CreateResponseVO();
    }

}
