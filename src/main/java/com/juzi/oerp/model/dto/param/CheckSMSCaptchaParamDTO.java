package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 校验短信验证码参数
 *
 * @author Juzi
 * @date 2020/7/17 11:50
 */
@Data
@ApiModel(description = "校验短信验证码参数")
public class CheckSMSCaptchaParamDTO {

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phoneNumber;

    /**
     * 验证码值
     */
    @ApiModelProperty("验证码")
    private String captcha;

}
