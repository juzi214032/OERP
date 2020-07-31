package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Positive;

/**
 * @author Juzi
 * @date 2020/7/16 15:22
 */
@Data
@ApiModel(description = "考试报名参数")
public class ApplyExamParamDTO {

    @ApiModelProperty("考试地点 id")
    @Positive(message = "考试地点id格式错误")
    private Integer examPlaceId;

}
