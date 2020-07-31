package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * 分页参数
 *
 * @author Juzi
 * @date 2020/7/15 12:25
 */
@Data
@ApiModel(value = "分页参数")
public class PageParamDTO {

    @ApiModelProperty("当前页码-从 1 开始")
    @Positive(message = "页码格式错误")
    private Integer pageOn = 1;

    @ApiModelProperty("每页条数")
    @Positive(message = "页大小格式错误")
    private Integer pageSize = 10;

    @ApiModelProperty("搜索关键字")
    @NotNull(message = "搜索关键词格式错误")
    private String keyword = "";
}
