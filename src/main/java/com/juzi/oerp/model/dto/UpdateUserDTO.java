package com.juzi.oerp.model.dto;

import lombok.Data;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

/**
 * @author Juzi
 * @date 2020/7/15 15:26
 */
@Data
public class UpdateUserDTO {

    /**
     * 用户 id
     */
    @Positive(message = "用户id格式错误")
    private Integer userId;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别：0未知/1男/2女
     */
    private Integer gender;

    /**
     * 角色：0普通用户/1管理员
     */
    private Integer role;

    /**
     * 身份证号码
     */
    private String identityNo;

    /**
     * 生日
     */
    private LocalDateTime birthday;

    /**
     * 手机号
     */
    private String phoneNumber;
}
