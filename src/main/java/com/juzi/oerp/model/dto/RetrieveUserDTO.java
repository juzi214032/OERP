package com.juzi.oerp.model.dto;

import com.juzi.oerp.model.dto.param.CheckSMSCaptchaParamDTO;
import lombok.Data;

@Data
public class RetrieveUserDTO {

    /**
     * 新密码
     */
    private String newPassword;


    /**
     * 手机号
     */
    private String phoneNumber;
}
