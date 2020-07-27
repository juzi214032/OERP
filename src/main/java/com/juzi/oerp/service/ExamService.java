package com.juzi.oerp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.dto.param.UpdateExamParamDTO;
import com.juzi.oerp.model.po.ExamPO;
import com.juzi.oerp.model.vo.ExamApplyInfoVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    IPage<ExamPO> getExamPlainInfoByPage(PageParamDTO pageParamDTO);

    /**
     * 获取考试详细信息
     *
     * @param examId 考试id
     * @return 考试详情页信息
     */
    ExamPO getExamDetailInfoById(Integer examId);

    /**
     * 获取考试报名信息
     *
     * @param examId 考试id
     * @return 考试报名信息
     */
    ExamApplyInfoVO getExamApplyInfoById(Integer examId);

    /**
     * 创建考试 - 管理员
     *
     * @param updateExamParamDTO 考试信息
     * @param image              图片
     * @param word               文档
     * @throws IOException IO异常
     */
    void createExam(UpdateExamParamDTO updateExamParamDTO, MultipartFile image, MultipartFile word) throws IOException;

    /**
     * 获取考试列表 - 管理员
     *
     * @param pageParamDTO 分页参数
     * @return 分页结果
     */
    IPage<ExamPO> getExamListByPage(PageParamDTO pageParamDTO);

    /**
     * 删除考试
     *
     * @param examId 考试 id
     */
    void deleteExam(Integer examId);
}
