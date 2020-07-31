package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

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
    @Length(min = 24, max = 24, message = "验证码id格式错误")
    private String captchaId;

    @ApiModelProperty("手机号")
    @Pattern(regexp = "(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-7|9])|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1|8|9]))\\d{8}", message = "手机号格式错误")
    private String phoneNumber;

}
