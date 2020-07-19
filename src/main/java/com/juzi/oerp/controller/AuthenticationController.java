package com.juzi.oerp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.juzi.oerp.model.dto.param.CheckImageCaptchaParamDTO;
import com.juzi.oerp.model.dto.param.SMSCaptchaParamDTO;
import com.juzi.oerp.model.dto.UserLoginDTO;
import com.juzi.oerp.model.dto.UserRegistionDTO;
import com.juzi.oerp.model.vo.CaptchaVO;
import com.juzi.oerp.model.vo.UserLoginVO;
import com.juzi.oerp.model.vo.response.CreateResponseVO;
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

    /**
     * 用户登录
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录",notes = "用户和管理员均使用此接口登录")
    public ResponseVO<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        UserLoginVO result = authenticationService.login(userLoginDTO);
        return new ResponseVO<>(result);
    }

    /**
     * 用户注册
     */
    @PostMapping("/registion")
    @ApiOperation("注册")
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
    @ApiOperation("获取图片验证码")
    public ResponseVO<CaptchaVO> getImageCaptcha() {
        CaptchaVO captcha = authenticationService.getImageCaptcha();
        return new ResponseVO<>(captcha);
    }

    /**
     * 校验图片验证码
     * @param checkImageCaptchaParamDTO 校验验证码参数
     * @return 校验成功
     */
    @PostMapping("/captcha/image")
    @ApiOperation("校验图片验证码")
    public ResponseVO<Object> checkImageCaptcha(@RequestBody CheckImageCaptchaParamDTO checkImageCaptchaParamDTO) {
        authenticationService.checkImageCaptcha(checkImageCaptchaParamDTO);
        return new CreateResponseVO();
    }

    /**
     * 获取短信验证码
     *
     * @param smsCaptchaParamDTO 短信验证码参数
     * @return 发送成功信息
     * @throws JsonProcessingException 发送短信验证码时转换 JSON 异常
     */
    @GetMapping("/captcha/sms")
    @ApiOperation("获取短信验证码")
    public ResponseVO<Object> getSMSCaptcha(@RequestBody SMSCaptchaParamDTO smsCaptchaParamDTO) throws JsonProcessingException {
        authenticationService.getSMSCaptcha(smsCaptchaParamDTO);
        return new CreateResponseVO();
    }

}
