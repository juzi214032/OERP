package com.juzi.oerp.controller.admin;

import com.juzi.oerp.model.dto.param.AuditApplicationParamDTO;
import com.juzi.oerp.model.vo.response.CreateResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.AuditApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 审核报名
 * @author Juzi
 * @date 2020/7/17 17:35
 */
@RestController
@RequestMapping("/admin/apply")
public class AduitApplicationController {

    @Autowired
    private AuditApplicationService auditApplicationService;

    /**
     * 审核报名
     *
     * @param auditApplicationParamDTO 审核报名参数
     * @return 审核结果
     */
    @PostMapping("/aduit")
    public ResponseVO<Object> auditApply(@RequestBody AuditApplicationParamDTO auditApplicationParamDTO) {
        auditApplicationService.auditApplication(auditApplicationParamDTO);
        return new CreateResponseVO();
    }

}
