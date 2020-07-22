package com.juzi.oerp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.juzi.oerp.model.dto.UserPasswordLoginDTO;
import com.juzi.oerp.model.dto.UserRegistionDTO;
import com.juzi.oerp.model.dto.UserSMSLoginDTO;
import com.juzi.oerp.model.dto.param.CheckImageCaptchaParamDTO;
import com.juzi.oerp.model.dto.param.CheckSMSCaptchaParamDTO;
import com.juzi.oerp.model.dto.param.SMSCaptchaParamDTO;
import com.juzi.oerp.model.vo.CaptchaVO;
import com.juzi.oerp.model.vo.UserLoginVO;
import com.juzi.oerp.model.vo.response.MessageResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juzi
 * @date 2020/7/14 14:40
 */
@RestController
@Api(tags = "身份认证")
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    @ApiOperation(value = "密码登录")
    public ResponseVO<UserLoginVO> loginByPassword(@RequestBody UserPasswordLoginDTO userPasswordLoginDTO) {
        UserLoginVO result = authenticationService.loginByPassword(userPasswordLoginDTO);
        return new ResponseVO<>(result);
    }

    @PostMapping("/loginByPassword/sms")
    @ApiOperation(value = "短信登录")
    public ResponseVO<UserLoginVO> loginBySMS(@RequestBody UserSMSLoginDTO userSMSLoginDTO) {
        UserLoginVO result = authenticationService.loginBySMS(userSMSLoginDTO);
        return new ResponseVO<>(result);
    }

    @PostMapping("/registion")
    @ApiOperation("注册")
    public ResponseVO<UserLoginVO> registion(UserRegistionDTO userRegistionDTO) {
        UserLoginVO result = authenticationService.registion(userRegistionDTO);
        return new ResponseVO<>(result);
    }

    @GetMapping("/captcha/image")
    @ApiOperation("获取图片验证码")
    public ResponseVO<CaptchaVO> getImageCaptcha() {
        CaptchaVO captcha = authenticationService.getImageCaptcha();
        return new ResponseVO<>(captcha);
    }

    @PostMapping("/captcha/image")
    @ApiOperation("校验图片验证码")
    public MessageResponseVO checkImageCaptcha(@RequestBody CheckImageCaptchaParamDTO checkImageCaptchaParamDTO) {
        authenticationService.checkImageCaptcha(checkImageCaptchaParamDTO);
        return new MessageResponseVO(20001);
    }

    @PostMapping("/captcha/sms")
    @ApiOperation("获取短信验证码")
    public MessageResponseVO getSMSCaptcha(@RequestBody SMSCaptchaParamDTO smsCaptchaParamDTO) throws JsonProcessingException {
        authenticationService.getSMSCaptcha(smsCaptchaParamDTO);
        return new MessageResponseVO(20002);
    }

    @PostMapping("/captcha/sms/check")
    @ApiOperation("校验短信验证码")
    public MessageResponseVO checkSMSCaptcha(@RequestBody CheckSMSCaptchaParamDTO checkSMSCaptchaParamDTO){
        authenticationService.checkSMSCaptcha(checkSMSCaptchaParamDTO);
        return new MessageResponseVO(20001);
    }
}
