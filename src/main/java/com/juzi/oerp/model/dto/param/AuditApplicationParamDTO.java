package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Positive;

/**
 * 审核报名
 *
 * @author Juzi
 * @date 2020/7/17 17:37
 */
@Data
@ApiModel(description = "审核报名参数")
public class AuditApplicationParamDTO {

    @ApiModelProperty("报名id")
    @Positive(message = "报名id格式错误")
    private Integer applyId;

    @ApiModelProperty("报名状态：2审核通过；3审核拒绝")
    @Range(min = 2, max = 3, message = "报名状态格式错误")
    private Integer status;

}
