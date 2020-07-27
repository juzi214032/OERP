package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Positive;

/**
 * @author Juzi
 * @date 2020/7/27 11:07
 */
@Data
@ApiModel(description = "新增报名参数")
public class CreateApplyParamDTO {

    @ApiModelProperty("用户id")
    @Positive(message = "用户id格式错误")
    private Integer userId;

    @ApiModelProperty("考试地点id")
    @Positive(message = "考试地点id格式错误")
    private Integer examPlaceId;

    @ApiModelProperty("报名状态：0已申请；1已支付；2审核通过；3审核拒绝")
    private Integer status;

}
