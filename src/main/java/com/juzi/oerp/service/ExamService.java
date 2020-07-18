package com.juzi.oerp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.po.ExamPO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Juzi
 * @since 2020-07-15
 */
public interface ExamService extends IService<ExamPO> {
    /**
     * 获取考试简要信息_分页
     *
     * @param pageParamDTO 分页参数
     * @return 考试简要信息
     */
    IPage<ExamPO> getExamPlainInfoByPage(@Param("pageParamDTO") PageParamDTO pageParamDTO);

    /**
     * 获取考试详细信息
     *
     * @param examId 考试id
     * @return 考试详情页信息
     */
    ExamPO getExamDetailInfoById(Integer examId);
}
