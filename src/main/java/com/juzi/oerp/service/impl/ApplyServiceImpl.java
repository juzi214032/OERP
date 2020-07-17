package com.juzi.oerp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.juzi.oerp.common.exception.ApplyException;
import com.juzi.oerp.common.store.LocalUserStore;
import com.juzi.oerp.dao.ExamDAO;
import com.juzi.oerp.mapper.UserExamMapper;
import com.juzi.oerp.model.dto.ExamAllInfoDTO;
import com.juzi.oerp.model.dto.param.ApplyExamParamDTO;
import com.juzi.oerp.model.po.UserExamPO;
import com.juzi.oerp.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author Juzi
 * @date 2020/7/16 15:30
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private UserExamMapper userExamMapper;

    @Autowired
    private ExamDAO examDAO;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public UserExamPO applyExam(ApplyExamParamDTO applyExamParamDTO) {
        ExamAllInfoDTO exam = examDAO.getExamByIds(applyExamParamDTO.getExamId(), applyExamParamDTO.getExamTimeId(), applyExamParamDTO.getExamPlaceId());
        Assert.notNull(exam, "考试不存在");

        LambdaQueryWrapper<UserExamPO> queryWrapper = new LambdaQueryWrapper<UserExamPO>()
                .eq(UserExamPO::getUserId, LocalUserStore.getLocalUser())
                .eq(UserExamPO::getExamId, applyExamParamDTO.getExamId())
                .eq(UserExamPO::getExamTimeId, applyExamParamDTO.getExamTimeId())
                .eq(UserExamPO::getExamPlaceId, applyExamParamDTO.getExamPlaceId());
        // 已报名人数
        Integer applyNumber = userExamMapper.selectCount(queryWrapper);

        // 人数已满，不能报名
        if (exam.getPeopleNumber() != -1 && applyNumber >= exam.getPeopleNumber()) {
            throw new ApplyException();
        }

        // 插入数据
        UserExamPO userExam = new UserExamPO();
        userExam
                .setUserId(LocalUserStore.getLocalUser())
                .setExamId(applyExamParamDTO.getExamId())
                .setExamTimeId(applyExamParamDTO.getExamTimeId())
                .setExamPlaceId(applyExamParamDTO.getExamPlaceId());
        userExamMapper.insert(userExam);

        return userExam;
    }

    @Override
    public void pay(Integer applyId) {
        UserExamPO userExamPO = new UserExamPO();
        userExamPO
                .setId(applyId)
                .setStatus(1);
        userExamMapper.updateById(userExamPO);
    }
}
