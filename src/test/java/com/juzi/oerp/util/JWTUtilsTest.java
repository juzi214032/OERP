package com.juzi.oerp.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTUtilsTest {

    /**
     * 创建 token
     */
    @Test
    void createToken() {
        String token = JWTUtils.createToken(1);
        boolean flag = JWTUtils.checkToken(token);
        assertTrue(flag);
    }

    /**
     * 解析 token
     */
    @Test
    void parseToken() {
        String token = JWTUtils.createToken(1);
        Integer userId = JWTUtils.parseToken(token);
        assertEquals(1,userId);
    }
}