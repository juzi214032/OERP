package com.juzi.oerp.model.vo;

import com.juzi.oerp.model.po.UserInfoPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户登录成功后返回的信息
 *
 * @author Juzi
 * @date 2020/7/14 15:35
 */
@Data
@ApiModel(description = "登录响应")
@Accessors(chain = true)
public class UserLoginVO {

    @ApiModelProperty("身份令牌")
    private String token;

    @ApiModelProperty("用户信息")
    private UserInfoPO userInfo;

}
