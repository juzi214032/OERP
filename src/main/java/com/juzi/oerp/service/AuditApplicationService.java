package com.juzi.oerp.service;

import com.juzi.oerp.model.dto.param.AuditApplicationParamDTO;

/**
 * 审核报名
 *
 * @author Juzi
 * @date 2020/7/17 17:41
 */
public interface AuditApplicationService {

    /**
     * 审核报名
     * @param auditApplicationParamDTO 审核报名参数
     */
    void auditApplication(AuditApplicationParamDTO auditApplicationParamDTO);

}
