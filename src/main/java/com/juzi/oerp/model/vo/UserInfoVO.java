package com.juzi.oerp.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.juzi.oerp.common.jackson.LocalDateTimeDeserializer;
import com.juzi.oerp.common.jackson.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户信息
 *
 * @author Juzi
 * @date 2020/7/15 12:11
 */
@Data
public class UserInfoVO {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 账号
     */
    private String username;

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

    /**
     * 创建时间
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateTime;
}
