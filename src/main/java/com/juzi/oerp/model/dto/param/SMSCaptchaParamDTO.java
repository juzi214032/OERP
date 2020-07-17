package com.juzi.oerp.model.dto.param;

import lombok.Data;

/**
 * 获取短信验证码参数
 *
 * @author Juzi
 * @date 2020/7/16 20:21
 */
@Data
public class SMSCaptchaParamDTO {

    /**
     * 验证码 id
     */
    private String captchaId;

    /**
     * 手机号码
     */
    private String phoneNumber;

}
