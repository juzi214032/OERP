package com.juzi.oerp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.juzi.oerp.model.dto.param.ApplyExamParamDTO;
import com.juzi.oerp.model.dto.param.CreateApplyParamDTO;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.po.UserExamPO;
import com.juzi.oerp.model.vo.ApplyInfoVO;

/**
 * @author Juzi
 * @date 2020/7/16 15:22
 */
public interface ApplyService {

    /**
     * 获取报名信息-分页
     *
     * @param pageParamDTO 分页参数
     * @return 报名信息
     */
    IPage<ApplyInfoVO> getApplyInfoByPage(PageParamDTO pageParamDTO);

    /**
     * 获取报名信息
     *
     * @param applyId 报名id
     * @return 报名信息
     */
    ApplyInfoVO getApplyInfoById(Integer applyId);

    /**
     * 创建报名
     *
     * @param createApplyParamDTO 创建报名参数
     */
    void createApplyInfo(CreateApplyParamDTO createApplyParamDTO);

    /**
     * 考试报名
     *
     * @param applyExamParamDTO 报名参数
     * @return 报名记录
     */
    UserExamPO applyExam(ApplyExamParamDTO applyExamParamDTO);

    /**
     * 支付报名费
     *
     * @param applyId 报名id
     */
    void pay(Integer applyId);
}
