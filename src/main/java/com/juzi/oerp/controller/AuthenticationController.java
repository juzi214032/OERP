package com.juzi.oerp.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.juzi.oerp.common.exception.AuthenticationException;
import com.juzi.oerp.mapper.UserMapper;
import com.juzi.oerp.model.dto.ChangePasswordDTO;
import com.juzi.oerp.model.dto.RetrieveUserDTO;
import com.juzi.oerp.model.dto.UserPasswordLoginDTO;
import com.juzi.oerp.model.dto.UserRegistionDTO;
import com.juzi.oerp.model.dto.UserSMSLoginDTO;
import com.juzi.oerp.model.dto.param.CheckImageCaptchaParamDTO;
import com.juzi.oerp.model.dto.param.CheckSMSCaptchaParamDTO;
import com.juzi.oerp.model.dto.param.SMSCaptchaParamDTO;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.model.vo.CaptchaVO;
import com.juzi.oerp.model.vo.UserLoginVO;
import com.juzi.oerp.model.vo.response.MessageResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    @ApiOperation(value = "密码登录", tags = "登录注册")
    public ResponseVO<UserLoginVO> loginByPassword(@RequestBody @Validated UserPasswordLoginDTO userPasswordLoginDTO) {
        UserLoginVO result = authenticationService.loginByPassword(userPasswordLoginDTO);
        return new ResponseVO<>(result);
    }

    @PostMapping("/login/sms")
    @ApiOperation(value = "短信登录", tags = "登录注册")
    public ResponseVO<UserLoginVO> loginBySMS(@RequestBody UserSMSLoginDTO userSMSLoginDTO) {
        UserLoginVO result = authenticationService.loginBySMS(userSMSLoginDTO);
        return new ResponseVO<>(result);
    }

    @PostMapping("/registion")
    @ApiOperation(value = "账号注册", tags = "登录注册")
    public ResponseVO<UserLoginVO> registion(@RequestBody UserRegistionDTO userRegistionDTO) {
        UserLoginVO result = authenticationService.registion(userRegistionDTO);
        return new ResponseVO<>(result);
    }

    @GetMapping("/captcha/image")
    @ApiOperation(value = "获取图片验证码", tags = "验证码")
    public ResponseVO<CaptchaVO> getImageCaptcha() {
        CaptchaVO captcha = authenticationService.getImageCaptcha();
        return new ResponseVO<>(captcha);
    }

    @PostMapping("/captcha/image")
    @ApiOperation(value = "校验图片验证码", tags = "验证码")
    public MessageResponseVO checkImageCaptcha(@RequestBody CheckImageCaptchaParamDTO checkImageCaptchaParamDTO) {
        authenticationService.checkImageCaptcha(checkImageCaptchaParamDTO);
        return new MessageResponseVO(20001);
    }

    @PostMapping("/captcha/sms")
    @ApiOperation(value = "获取短信验证码", tags = "验证码")
    public MessageResponseVO getSMSCaptcha(@RequestBody SMSCaptchaParamDTO smsCaptchaParamDTO) throws JsonProcessingException {
        authenticationService.getSMSCaptcha(smsCaptchaParamDTO);
        return new MessageResponseVO(20002);
    }

    @PostMapping("/captcha/sms/check")
    @ApiOperation(value = "校验短信验证码", tags = "验证码")
    public MessageResponseVO checkSMSCaptcha(@RequestBody CheckSMSCaptchaParamDTO checkSMSCaptchaParamDTO) {
        authenticationService.checkSMSCaptcha(checkSMSCaptchaParamDTO);
        return new MessageResponseVO(20001);
    }

    @PutMapping("/password")
    @ApiOperation(value = "修改密码", notes = "通过原密码修改密码", tags = "账户信息")
    public MessageResponseVO updatePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        authenticationService.updatePassword(changePasswordDTO);
        return new MessageResponseVO(20010);
    }

    @PutMapping("/phone/{phoneNumber}")
    @ApiOperation(value = "修改手机号", tags = "账户信息")
    public MessageResponseVO updatePhoneNumber(@PathVariable String phoneNumber) {
        authenticationService.updatePhoneNumber(phoneNumber);
        return new MessageResponseVO(20010);
    }

    @GetMapping("/phone/{phoneNumber}")
    @ApiOperation(value = "检测手机号", notes = "判断该手机号是否已经注册过", tags = "登录注册")
    public MessageResponseVO retrieveUserByPhone(@PathVariable String phoneNumber) {
        UserPO userPO = userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getPhoneNumber, phoneNumber));
        if (userPO == null) {
            throw new AuthenticationException(40010);
        }
        return new MessageResponseVO(20008);
    }

    @PutMapping("/password/sms")
    @ApiOperation(value = "重置密码", notes = "通过短信验证码重置密码", tags = "账户信息")
    public MessageResponseVO retrieveUser(@RequestBody RetrieveUserDTO retrieveUserDTO) {
        authenticationService.resetPassword(retrieveUserDTO);
        return new MessageResponseVO(20010);
    }
}
