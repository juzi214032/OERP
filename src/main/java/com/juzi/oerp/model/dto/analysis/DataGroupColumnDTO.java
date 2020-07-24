package com.juzi.oerp.model.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Juzi
 * @date 2020/7/22 10:49
 */
@Data
@ApiModel(description = "考生性别对比")
public class DataGroupColumnDTO {

    @ApiModelProperty("月份")
    private String month;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("数量")
    private String value;

}
