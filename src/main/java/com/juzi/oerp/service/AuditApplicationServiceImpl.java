package com.juzi.oerp.service;

import com.juzi.oerp.mapper.UserExamMapper;
import com.juzi.oerp.model.dto.param.AuditApplicationParamDTO;
import com.juzi.oerp.model.po.UserExamPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Juzi
 * @date 2020/7/17 17:42
 */
@Service
public class AuditApplicationServiceImpl implements AuditApplicationService {

    @Autowired
    private UserExamMapper userExamMapper;

    @Override
    public void auditApplication(AuditApplicationParamDTO auditApplicationParamDTO) {
        UserExamPO userExam = new UserExamPO();
        userExam
                .setId(auditApplicationParamDTO.getApplyId())
                .setStatus(auditApplicationParamDTO.getStatus());
        userExamMapper.updateById(userExam);
    }
}
