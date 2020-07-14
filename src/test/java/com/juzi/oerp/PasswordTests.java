package com.juzi.oerp;

import cn.hutool.crypto.SecureUtil;
import org.junit.jupiter.api.Test;

/**
 * @author Juzi
 * @date 2020/7/13 20:15
 */
public class PasswordTests {
    @Test
    void crypt(){
        System.out.println(SecureUtil.md5("jqsmx1731815301"));
    }
}
