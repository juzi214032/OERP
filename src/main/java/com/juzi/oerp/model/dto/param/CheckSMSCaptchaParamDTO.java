package com.juzi.oerp.model.dto.param;

import lombok.Data;

/**
 * 校验短信验证码参数
 *
 * @author Juzi
 * @date 2020/7/17 11:50
 */
@Data
public class CheckSMSCaptchaParamDTO {

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 验证码值
     */
    private String captcha;

}
