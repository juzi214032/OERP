package com.juzi.oerp.model.dto.param;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.juzi.oerp.common.jackson.CreateExamParamDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
public class UpdateExamParamDTO {

    @NotBlank(message = "考试名称不能为空")
    @ApiModelProperty("考试名称")
    private String title;

    @NotBlank(message = "考试描述不能为空")
    @ApiModelProperty("考试描述")
    private String description;

    @NotNull(message = "报名开始时间格式错误")
    @ApiModelProperty("报名开始时间")
    private LocalDateTime beginTime;

    @NotNull(message = "报名截止时间格式错误")
    @ApiModelProperty("报名截止时间")
    private LocalDateTime endTime;

    @Positive(message = "报名费用格式错误")
    @ApiModelProperty("报名费用")
    private BigDecimal price;

    @ApiModelProperty("时间地点")
    @NotEmpty(message = "时间地点不能为空")
    private Map<LocalDateTime, List<CreateExamPlaceParamDTO>> timePlace;
}
