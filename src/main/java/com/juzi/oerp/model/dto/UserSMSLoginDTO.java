package com.juzi.oerp.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Juzi
 * @date 2020/7/19 20:34
 */
@Data
@ApiModel(description = "短信登录参数")
public class UserSMSLoginDTO {

    @ApiModelProperty("手机号")
    @Pattern(regexp = "(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-7|9])|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1|8|9]))\\d{8}", message = "手机号格式错误")
    private String phoneNumber;

    @Size(min = 6, max = 6,message = "验证码长度应为6位数字")
    @ApiModelProperty("验证码")
    private String captcha;
}
