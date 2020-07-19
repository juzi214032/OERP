package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Juzi
 * @date 2020/7/16 15:22
 */
@Data
@ApiModel(description = "考试报名参数")
public class ApplyExamParamDTO {

    @ApiModelProperty("考试 id")
    private Integer examId;

    @ApiModelProperty("考试时间 id")
    private Integer examTimeId;

    @ApiModelProperty("考试地点 id")
    private Integer examPlaceId;

}
