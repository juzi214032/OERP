package com.juzi.oerp.model.dto;

import lombok.Data;

/**
 * 用户注册
 *
 * @author Juzi
 * @date 2020/7/14 15:08
 */
@Data
public class UserRegistionDTO {

    /**
     * 用户名
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

}
