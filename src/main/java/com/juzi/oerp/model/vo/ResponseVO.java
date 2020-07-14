package com.juzi.oerp.model.vo;

import lombok.Data;

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
    private String msg;

    /**
     * 响应数据
     */
    private T data;
}
