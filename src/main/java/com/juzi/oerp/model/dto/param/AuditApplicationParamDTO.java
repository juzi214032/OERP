package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
    private Integer applyId;

    @ApiModelProperty("报名状态：2审核通过；3审核拒绝")
    private Integer status;

}
