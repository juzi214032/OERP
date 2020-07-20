package com.juzi.oerp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.juzi.oerp.common.constant.JWTConstants;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Juzi
 * @date 2020/7/14 15:45
 */
public class JWTUtils {

    /**
     * JWT 校验器
     */
    private static final JWTVerifier JWT_VERIFIER = JWT.require(Algorithm.HMAC256(JWTConstants.JWT_SECRET)).build();

    /**
     * 创建 token
     *
     * @return token 字符串
     */
    public static String createToken(Integer userId) {
        // 创建过期时间：7天后
        LocalDateTime expireDateTime = LocalDateTime.now().plusDays(7);
        Date expireDate = Date.from(expireDateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant());

        String token = JWT.create()
                .withIssuer("OERM")
                .withExpiresAt(expireDate)
                .withClaim("userId", userId)
                .sign(Algorithm.HMAC256(JWTConstants.JWT_SECRET));

        return JWTConstants.TOKEN_HEAD + token;
    }

    /**
     * 解析 token
     *
     * @param token accessToken
     * @return 用户id
     */
    public static Integer parseToken(String token) {
        return JWTUtils.JWT_VERIFIER
                .verify(token)
                .getClaim("userId")
                .asInt();
    }

    /**
     * 校验 token 是否有效
     *
     * @param token accessToken
     * @return 是否有效
     */
    public static boolean checkToken(String token) {
        try {
            JWTUtils.JWT_VERIFIER.verify(token);
            return true;
        } catch (JWTDecodeException e) {
            return false;
        }
    }
}
