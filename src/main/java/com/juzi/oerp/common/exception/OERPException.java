package com.juzi.oerp.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author Juzi
 * @date 2020/7/14 15:19
 */
@Getter
public class OERPException extends RuntimeException {

    private static final long serialVersionUID = -3048551174352608828L;

    /**
     * 消息码
     */
    private Integer code;

    public OERPException() {
    }

    public OERPException(Integer code) {
        this.code = code;
    }
}
