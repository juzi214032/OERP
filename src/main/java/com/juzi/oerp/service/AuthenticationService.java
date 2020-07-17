package com.juzi.oerp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.juzi.oerp.model.dto.param.CheckImageCaptchaParamDTO;
import com.juzi.oerp.model.dto.param.CheckSMSCaptchaParamDTO;
import com.juzi.oerp.model.dto.param.SMSCaptchaParamDTO;
import com.juzi.oerp.model.dto.UserLoginDTO;
import com.juzi.oerp.model.dto.UserRegistionDTO;
import com.juzi.oerp.model.vo.CaptchaVO;
import com.juzi.oerp.model.vo.UserLoginVO;

/**
 * 认证服务
 *
 * @author Juzi
 * @date 2020/7/14 15:16
 */
public interface AuthenticationService {

    /**
     * 用户登录
     *
     * @param userLoginDTO 登录参数
     * @return token 和用户信息
     */
    UserLoginVO login(UserLoginDTO userLoginDTO);

    /**
     * 用户注册
     *
     * @param userRegistionDTO 注册信息
     */
    UserLoginVO registion(UserRegistionDTO userRegistionDTO);

    /**
     * 获取验证码
     *
     * @return 验证码和验证码 id
     */
    CaptchaVO getImageCaptcha();

    /**
     * 校验图片验证码
     * @param checkImageCaptchaParamDTO 校验图片验证码参数
     */
    void checkImageCaptcha(CheckImageCaptchaParamDTO checkImageCaptchaParamDTO);

    /**
     * 获取短信验证码
     *
     * @param smsCaptchaParamDTO 短信验证码id和手机号
     * @throws JsonProcessingException Json 序列化异常
     */
    void getSMSCaptcha(SMSCaptchaParamDTO smsCaptchaParamDTO) throws JsonProcessingException;

    /**
     * 校验短信验证码
     * @param checkSMSCaptchaParamDTO 校验短信验证码参数
     */
    void checkSMSCaptcha(CheckSMSCaptchaParamDTO checkSMSCaptchaParamDTO);
}
