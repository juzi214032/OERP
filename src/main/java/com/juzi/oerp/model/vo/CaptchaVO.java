package com.juzi.oerp.model.vo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Juzi
 * @date 2020/7/16 12:13
 */
@Data
@Accessors(chain = true)
public class CaptchaVO {

    /**
     * 验证码 id
     */
    private String captchaId;

    /**
     * 验证码图片内容
     * Base64 格式
     */
    private String captchaImageBase64;
}
