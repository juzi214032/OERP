package com.juzi.oerp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.juzi.oerp.common.constant.JWTConstants;
import com.juzi.oerp.common.exception.AuthenticationException;

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
     * @param bearerToken token
     * @return 用户id
     */
    public static Integer parseToken(String bearerToken) {
        String jwtToken = JWTUtils.extractJwtToken(bearerToken);

        return JWTUtils.JWT_VERIFIER
                .verify(jwtToken)
                .getClaim("userId")
                .asInt();
    }

    /**
     * 校验 token 是否有效
     *
     * @param bearerToken
     * @return 是否有效
     */
    public static boolean checkToken(String bearerToken) {
        String jwtToken = JWTUtils.extractJwtToken(bearerToken);

        try {
            JWTUtils.JWT_VERIFIER.verify(jwtToken);
            return true;
        } catch (JWTDecodeException e) {
            return false;
        }
    }

    private static String extractJwtToken(String bearerToken) {
        if (!bearerToken.startsWith(JWTConstants.TOKEN_HEAD)) {
            throw new AuthenticationException(40003);
        }
        return bearerToken.substring(7);
    }
}
