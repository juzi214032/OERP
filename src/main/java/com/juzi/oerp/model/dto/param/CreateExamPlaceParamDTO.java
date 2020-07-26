package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Juzi
 * @date 2020/7/25 20:10
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "创建考试参数")
public class CreateExamPlaceParamDTO {

    @ApiModelProperty("考试地点")
    private String examPlace;

    @ApiModelProperty("限制人数；-1 无限制")
    private Integer peopleNumber;

}
