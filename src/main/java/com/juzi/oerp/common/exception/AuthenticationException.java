package com.juzi.oerp.common.exception;

/**
 * 认证异常
 *
 * @author Juzi
 * @date 2020/7/14 15:20
 */
public class AuthenticationException extends OERPException {
    public AuthenticationException(Integer code) {
        super(code);
    }

    private static final long serialVersionUID = 475369999619649095L;
}
