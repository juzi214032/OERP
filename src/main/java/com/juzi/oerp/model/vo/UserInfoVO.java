package com.juzi.oerp.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户信息
 *
 * @author Juzi
 * @date 2020/7/15 12:11
 */
@Data
@ApiModel(description = "用户信息")
public class UserInfoVO {

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("头像")
    private String avatarUrl;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("学历")
    private String education;

    @ApiModelProperty("角色：0普通；1管理员")
    private Integer role;

    @ApiModelProperty("身份证号码")
    private String identityNo;

    @ApiModelProperty("生日")
    private LocalDateTime birthday;

    @ApiModelProperty("手机号")
    private String phoneNumber;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
