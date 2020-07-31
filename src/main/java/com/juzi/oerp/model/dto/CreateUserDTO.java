package com.juzi.oerp.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

/**
 * @author Juzi
 * @date 2020/7/15 15:16
 */
@Data
public class CreateUserDTO {

    /**
     * 账号
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
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
    @Range(min = 0, max = 2, message = "性别格式错误")
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
    @Past(message = "生日时间必须是过去的时间")
    private LocalDateTime birthday;

    /**
     * 手机号
     */
    private String phoneNo;

}
