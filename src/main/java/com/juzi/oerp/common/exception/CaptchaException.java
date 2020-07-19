package com.juzi.oerp.common.exception;

/**
 * @author Juzi
 * @date 2020/7/16 20:50
 */
public class CaptchaException extends OERPException {

    private static final long serialVersionUID = -2861306133593863779L;

    public CaptchaException(Integer code) {
        super(code);
    }
}
