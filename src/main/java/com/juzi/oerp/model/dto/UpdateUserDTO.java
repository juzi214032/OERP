package com.juzi.oerp.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.juzi.oerp.common.jackson.LocalDateTimeDeserializer;
import com.juzi.oerp.common.jackson.LocalDateTimeSerializer;
import lombok.Data;

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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime birthday;

    /**
     * 手机号
     */
    private String phoneNo;
}
