package com.juzi.oerp.model.dto.param;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.juzi.oerp.common.jackson.CreateExamParamDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 创建考试
 *
 * @author Juzi
 * @date 2020/7/25 13:48
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "创建考试参数")
@JsonDeserialize(using = CreateExamParamDeserializer.class)
public class CreateExamParamDTO {

    @ApiModelProperty("考试名称")
    private String title;

    @ApiModelProperty("考试描述")
    private String description;

    @ApiModelProperty("报名开始时间")
    private LocalDateTime beginTime;

    @ApiModelProperty("报名截止时间")
    private LocalDateTime endTime;

    @ApiModelProperty("报名费用")
    private BigDecimal price;

    @ApiModelProperty("时间地点")
    private Map<LocalDateTime, List<CreateExamPlaceParamDTO>> timePlace;
}
