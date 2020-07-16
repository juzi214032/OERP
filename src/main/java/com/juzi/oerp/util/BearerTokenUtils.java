package com.juzi.oerp.util;

import com.juzi.oerp.common.exception.AuthenticationException;

/**
 * Bearer Token 工具类
 * @author Juzi
 * @date 2020/7/15 23:44
 */
public class BearerTokenUtils {
    /**
     * 解析 token，将首部的 Bearer 删掉
     * @param bearerToken token
     * @return JWT Token
     */
    public static String parseToken(String bearerToken){
        boolean bearerTokenIsValid = BearerTokenUtils.checkToken(bearerToken);
        // bearerToken 无效
        if(!bearerTokenIsValid){
            throw new AuthenticationException();
        }
        return bearerToken.substring(7);
    }

    /**
     * 检测是否是 Bearer Token
     * @param bearerToken token
     * @return 是否为 Bearer Token
     */
    public static boolean checkToken(String bearerToken){
        return bearerToken.startsWith("Bearer ");
    }
}
