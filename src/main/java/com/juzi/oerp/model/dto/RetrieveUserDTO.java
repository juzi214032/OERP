package com.juzi.oerp.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RetrieveUserDTO {

    /**
     * 新密码
     */
    @NotBlank(message = "密码不能为空")
    private String newPassword;

    /**
     * 手机号
     */
    @Pattern(regexp = "(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-7|9])|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1|8|9]))\\d{8}", message = "手机号格式错误")
    private String phoneNumber;
}
