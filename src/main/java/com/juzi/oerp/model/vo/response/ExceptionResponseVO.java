package com.juzi.oerp.model.vo.response;

/**
 * 异常返回信息
 *
 * @author Juzi
 * @date 2020/7/17 09:02
 */
public class ExceptionResponseVO extends ResponseVO<Object> {
    public ExceptionResponseVO(Integer code, String message) {
        super(code, message);
    }
}
