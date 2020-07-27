package com.juzi.oerp.model.vo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 异常返回信息
 *
 * @author Juzi
 * @date 2020/7/17 09:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ExceptionResponseVO extends MessageResponseVO {

    private String detail;

    public ExceptionResponseVO(Integer code) {
        super(code);
    }

    public ExceptionResponseVO(Integer code, String detail) {
        super(code);
        this.detail = detail;
    }

    public ExceptionResponseVO(Integer code, String message, String detail) {
        super(code, message);
        this.detail = detail;
    }

}
