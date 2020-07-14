package com.juzi.oerp.model.vo;

import com.juzi.oerp.model.po.UserInfoPO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户登录成功后返回的信息
 *
 * @author Juzi
 * @date 2020/7/14 15:35
 */
@Data
@Accessors(chain = true)
public class UserLoginVO {

    /**
     * access token
     */
    private String token;

    /**
     * 用户信息
     */
    private UserInfoPO userInfo;

}
