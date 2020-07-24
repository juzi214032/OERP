package com.juzi.oerp.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Juzi
 * @date 2020/7/14 15:31
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "登录参数")
public class UserPasswordLoginDTO {

    @ApiModelProperty("账号")
    @Size(min = 4,max = 10,message = "账号长度为4至10个字符")
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}
