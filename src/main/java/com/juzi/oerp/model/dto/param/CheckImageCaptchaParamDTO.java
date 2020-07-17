package com.juzi.oerp.model.dto.param;

import lombok.Data;

/**
 * 校验图片验证码参数
 *
 * @author Juzi
 * @date 2020/7/17 11:23
 */
@Data
public class CheckImageCaptchaParamDTO {

    /**
     * 验证码 id
     */
    private String captchaId;

    /**
     * 验证码值
     */
    private String captcha;
}
