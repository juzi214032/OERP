package com.juzi.oerp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzi.oerp.mapper.ExamMapper;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.po.ExamPO;
import com.juzi.oerp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public IPage<ExamPO> getExamPlainInfoByPage(PageParamDTO pageParamDTO) {
        IPage<ExamPO> page = new Page<>(pageParamDTO.getPageOn(), pageParamDTO.getPageSize());
        LambdaQueryWrapper<ExamPO> queryWrapper = new LambdaQueryWrapper<ExamPO>()
                .select(ExamPO::getTitle, ExamPO::getImageUrl, ExamPO::getDescription, ExamPO::getId)
                .orderByDesc(ExamPO::getCreateTime);
        return examMapper.selectPage(page, queryWrapper);
    }
}
