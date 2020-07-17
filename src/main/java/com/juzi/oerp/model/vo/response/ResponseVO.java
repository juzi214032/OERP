package com.juzi.oerp.model.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一响应数据格式
 *
 * @author Juzi
 * @date 2020/7/14 15:32
 */
@Data
public class ResponseVO<T> {

    /**
     * 消息代码
     */
    private Integer code;

    /**
     * 消息信息
     */
    private String message;

    /**
     * 响应数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResponseVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseVO(T data) {
        this.code=200;
        this.message="ok";
        this.data = data;
    }
}
