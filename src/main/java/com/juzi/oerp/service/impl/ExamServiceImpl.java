package com.juzi.oerp.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzi.oerp.common.exception.ApplyException;
import com.juzi.oerp.dao.ExamDAO;
import com.juzi.oerp.mapper.ExamMapper;
import com.juzi.oerp.model.dto.ExamApplyInfoDTO;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.po.ExamPO;
import com.juzi.oerp.model.po.ExamPlacePO;
import com.juzi.oerp.model.vo.ExamApplyInfoVO;
import com.juzi.oerp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * 考试服务
 *
 * @author Juzi
 * @since 2020-07-15
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, ExamPO> implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private ExamDAO examDAO;

    @Override
    public IPage<ExamPO> getExamPlainInfoByPage(PageParamDTO pageParamDTO) {
        IPage<ExamPO> page = new Page<>(pageParamDTO.getPageOn(), pageParamDTO.getPageSize());
        LambdaQueryWrapper<ExamPO> queryWrapper = new LambdaQueryWrapper<ExamPO>()
                .select(ExamPO::getTitle, ExamPO::getImageUrl, ExamPO::getDescription, ExamPO::getId)
                .like(!StringUtils.isEmpty(pageParamDTO.getKeyword()), ExamPO::getTitle, pageParamDTO.getKeyword())
                .orderByDesc(ExamPO::getCreateTime);
        return examMapper.selectPage(page, queryWrapper);
    }

    @Override
    public ExamPO getExamDetailInfoById(Integer examId) {
        LambdaQueryWrapper<ExamPO> queryWrapper = new LambdaQueryWrapper<ExamPO>()
                .select(ExamPO::getTitle, ExamPO::getImageUrl, ExamPO::getDescription, ExamPO::getId, ExamPO::getDetail, ExamPO::getPrice)
                .eq(ExamPO::getId, examId);
        return examMapper.selectOne(queryWrapper);
    }

    @Override
    public ExamApplyInfoVO getExamApplyInfoById(Integer examId) {
        List<ExamApplyInfoDTO> examApplyInfoDTOList = examDAO.getExamApplyInfoById(examId);
        if (CollectionUtil.isEmpty(examApplyInfoDTOList)) {
            throw new ApplyException(40007);
        }

        Map<LocalDateTime, List<ExamPlacePO>> timePlace = examApplyInfoDTOList
                .stream()
                .collect(groupingBy(ExamApplyInfoDTO::getExamTime, mapping(examApplyInfoDTO -> {
                    ExamPlacePO examPlacePO = new ExamPlacePO();
                    examPlacePO.setExamPlace(examApplyInfoDTO.getExamPlace());
                    examPlacePO.setPeopleNumber(examApplyInfoDTO.getPeopleNumber());
                    return examPlacePO;
                }, toList())));

        ExamApplyInfoVO examApplyInfoVO = new ExamApplyInfoVO();
        examApplyInfoVO
                .setId(examId)
                .setTimePlace(timePlace)
                .setTitle(examApplyInfoDTOList.get(0).getTitle());

        return examApplyInfoVO;
    }
}
