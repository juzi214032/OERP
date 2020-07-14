package com.juzi.oerp.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Juzi
 * @date 2020/7/14 15:31
 */
@Data
@Accessors(chain = true)
public class UserLoginDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
