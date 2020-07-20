package com.juzi.oerp.model.vo.response;

import lombok.Data;

/**
 * @author Juzi
 * @date 2020/7/20 14:21
 */
@Data
public class MessageResponseVO extends ResponseVO<Void> {

    public MessageResponseVO(Integer code) {
        super(code);
    }

    public MessageResponseVO(Integer code, String message) {
        super(code, message);
    }
}
