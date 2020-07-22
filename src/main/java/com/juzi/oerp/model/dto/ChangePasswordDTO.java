package com.juzi.oerp.model.dto;

import lombok.Data;

@Data
public class ChangePasswordDTO {

    /**
     * 用户旧密码
     */
    private String oldPassword;

    /**
     * 用户新密码
     */
    private String newPassword;

}
