package com.juzi.oerp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzi.oerp.common.exception.ApplyException;
import com.juzi.oerp.common.exception.OERPException;
import com.juzi.oerp.common.store.LocalUserStore;
import com.juzi.oerp.dao.ApplyDAO;
import com.juzi.oerp.mapper.ExamPlaceMapper;
import com.juzi.oerp.mapper.UserExamMapper;
import com.juzi.oerp.mapper.UserMapper;
import com.juzi.oerp.model.dto.param.ApplyExamParamDTO;
import com.juzi.oerp.model.dto.param.CreateApplyParamDTO;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.po.ExamPlacePO;
import com.juzi.oerp.model.po.UserExamPO;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.model.vo.ApplyInfoVO;
import com.juzi.oerp.service.ApplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ApplyDAO applyDAO;

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<ApplyInfoVO> getApplyInfoByPage(PageParamDTO pageParamDTO) {
        IPage<ApplyInfoVO> page = new Page<>(pageParamDTO.getPageOn(), pageParamDTO.getPageSize());
        return applyDAO.getApplyInfoByPage(page);
    }

    @Override
    public ApplyInfoVO getApplyInfoById(Integer applyId) {
        return applyDAO.getApplyInfoById(applyId);
    }

    @Override
    public void createApplyInfo(CreateApplyParamDTO createApplyParamDTO) {
        UserPO user = userMapper.selectById(createApplyParamDTO.getUserId());
        if (user == null) {
            throw new OERPException(40016);
        }

        ExamPlacePO examPlacePO = examPlaceMapper.selectById(createApplyParamDTO.getExamPlaceId());
        if (examPlacePO == null) {
            throw new OERPException(40007);
        }

        UserExamPO userExamPO = new UserExamPO();
        BeanUtils.copyProperties(createApplyParamDTO, userExamPO);
        userExamMapper.insert(userExamPO);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public UserExamPO applyExam(ApplyExamParamDTO applyExamParamDTO) {
        ExamPlacePO examPlacePO = examPlaceMapper.selectOne(new LambdaQueryWrapper<ExamPlacePO>().eq(ExamPlacePO::getId, applyExamParamDTO.getExamPlaceId()));
        if (examPlacePO == null) {
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
