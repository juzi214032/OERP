package com.juzi.oerp.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Pattern(regexp = "(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-7|9])|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1|8|9]))\\d{8}", message = "手机号格式错误")
    private String phoneNumber;

    @ApiModelProperty("账号")
    @Size(min = 4,max = 10,message = "账号长度为4至10个字符")
    private String username;

    @ApiModelProperty("密码")
    @Pattern(regexp = "\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[A-Z])(?=\\S*[a-z])(?=\\S*[!@#$%^&*? ])\\S*",message = "密码最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符")
    private String password;

}
