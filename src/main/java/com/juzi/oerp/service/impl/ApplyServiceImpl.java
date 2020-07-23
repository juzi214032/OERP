package com.juzi.oerp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.juzi.oerp.common.exception.ApplyException;
import com.juzi.oerp.common.store.LocalUserStore;
import com.juzi.oerp.dao.ExamDAO;
import com.juzi.oerp.mapper.ExamPlaceMapper;
import com.juzi.oerp.mapper.UserExamMapper;
import com.juzi.oerp.model.dto.ExamAllInfoDTO;
import com.juzi.oerp.model.dto.param.ApplyExamParamDTO;
import com.juzi.oerp.model.po.ExamPlacePO;
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
    private ExamPlaceMapper examPlaceMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public UserExamPO applyExam(ApplyExamParamDTO applyExamParamDTO) {
        ExamPlacePO examPlacePO = examPlaceMapper.selectOne(new LambdaQueryWrapper<ExamPlacePO>().eq(ExamPlacePO::getId, applyExamParamDTO.getExamPlaceId()));
        if(examPlacePO == null){
            throw new ApplyException(40007);
        }

        LambdaQueryWrapper<UserExamPO> queryWrapper = new LambdaQueryWrapper<UserExamPO>()
                .eq(UserExamPO::getExamPlaceId, applyExamParamDTO.getExamPlaceId());
        // 已报名人数
        Integer applyNumber = userExamMapper.selectCount(queryWrapper);

        // 人数已满，不能报名
        if (examPlacePO.getPeopleNumber() != -1 && applyNumber >= examPlacePO.getPeopleNumber()) {
            throw new ApplyException(40008);
        }

        // 插入数据
        UserExamPO userExam = new UserExamPO();
        userExam
                .setUserId(LocalUserStore.getLocalUser())
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
