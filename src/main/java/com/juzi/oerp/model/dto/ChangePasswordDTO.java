package com.juzi.oerp.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ChangePasswordDTO {

    /**
     * 用户旧密码
     */
    @NotBlank(message = "密码不能为空")
    private String oldPassword;

    /**
     * 用户新密码
     */
    @NotBlank(message = "密码不能为空")
    private String newPassword;

}
