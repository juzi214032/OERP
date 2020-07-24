package com.juzi.oerp.model.dto;

import lombok.Data;

@Data
public class ChangePasswordByPhoneNumDTO {

    /**
     * 用户新密码
     */
    private String newPassword;

    /**
     * 用户手机号
     */
    private String phoneNumber;
}
