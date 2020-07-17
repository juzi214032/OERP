package com.juzi.oerp.service;

import com.juzi.oerp.model.dto.param.ApplyExamParamDTO;
import com.juzi.oerp.model.po.UserExamPO;

/**
 * @author Juzi
 * @date 2020/7/16 15:22
 */
public interface ApplyService {
    /**
     * 考试报名
     * @param applyExamParamDTO 报名参数
     * @return 报名记录
     */
    UserExamPO applyExam(ApplyExamParamDTO applyExamParamDTO);

    /**
     * 支付报名费
     * @param applyId 报名id
     */
    void pay(Integer applyId);
}
