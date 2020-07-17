package com.juzi.oerp.model.dto.param;

import lombok.Data;

/**
 * 审核报名
 *
 * @author Juzi
 * @date 2020/7/17 17:37
 */
@Data
public class AuditApplicationParamDTO {

    /**
     * 报名状态
     * 2-审核通过
     * 3-审核未通过
     */
    private Integer status;

    /**
     * 报名id
     */
    private Integer applyId;

}
