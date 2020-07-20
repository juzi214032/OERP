package com.juzi.oerp.model.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "统一响应对象")
public class ResponseVO<T> {

    @ApiModelProperty("响应码")
    private Integer code;

    @ApiModelProperty("响应消息")
    private String message;

    @ApiModelProperty("响应数据")
    private T data;

    public ResponseVO(Integer code) {
        this.code = code;
    }

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
