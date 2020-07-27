package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
    @Length(min = 24, max = 24, message = "验证码id格式错误")
    private String captchaId;

    @ApiModelProperty("验证码值")
    @Length(min = 5, max = 5, message = "验证码格式错误")
    private String captcha;
}
