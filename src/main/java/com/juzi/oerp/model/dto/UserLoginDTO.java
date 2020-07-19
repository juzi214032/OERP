package com.juzi.oerp.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Juzi
 * @date 2020/7/14 15:31
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "登录参数")
public class UserLoginDTO {

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
