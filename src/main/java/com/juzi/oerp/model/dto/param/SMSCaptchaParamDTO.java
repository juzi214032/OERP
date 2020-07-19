package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 获取短信验证码参数
 *
 * @author Juzi
 * @date 2020/7/16 20:21
 */
@Data
@ApiModel(description = "获取短信验证码参数")
public class SMSCaptchaParamDTO {

    @ApiModelProperty("验证码 id")
    private String captchaId;

    @ApiModelProperty("手机号")
    private String phoneNumber;

}
