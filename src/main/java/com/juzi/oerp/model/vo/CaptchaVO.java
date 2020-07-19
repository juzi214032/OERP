package com.juzi.oerp.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Juzi
 * @date 2020/7/16 12:13
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "图片验证码响应")
public class CaptchaVO {

    @ApiModelProperty("验证码 id")
    private String captchaId;

    @ApiModelProperty("验证码图片-Base64")
    private String captchaImageBase64;
}
