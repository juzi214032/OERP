package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 校验图片验证码参数
 *
 * @author Juzi
 * @date 2020/7/17 11:23
 */
@Data
@ApiModel(description = "校验图片验证码参数")
public class CheckImageCaptchaParamDTO {

    @ApiModelProperty("验证码 id")
    private String captchaId;

    @ApiModelProperty("验证码值")
    private String captcha;
}
