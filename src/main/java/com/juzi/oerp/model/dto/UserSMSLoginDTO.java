package com.juzi.oerp.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Juzi
 * @date 2020/7/19 20:34
 */
@Data
@ApiModel(description = "短信登录参数")
public class UserSMSLoginDTO {
    @ApiModelProperty("手机号")
    private String phoneNumber;

    @ApiModelProperty("验证码")
    private String captcha;
}
