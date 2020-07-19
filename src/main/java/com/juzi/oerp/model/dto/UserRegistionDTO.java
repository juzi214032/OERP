package com.juzi.oerp.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户注册
 *
 * @author Juzi
 * @date 2020/7/14 15:08
 */
@Data
@ApiModel(description = "注册参数")
public class UserRegistionDTO {

    @ApiModelProperty("手机号")
    private String phoneNumber;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("短信验证码")
    private String smsCaptcha;

}
