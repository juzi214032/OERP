package com.juzi.oerp.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzi.oerp.common.exception.OERPException;
import com.juzi.oerp.common.store.LocalUserStore;
import com.juzi.oerp.dao.UserDAO;
import com.juzi.oerp.mapper.UserInfoMapper;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.po.UserInfoPO;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.model.vo.UserApplyExamVO;
import com.juzi.oerp.model.vo.UserInfoVO;
import com.juzi.oerp.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Juzi
 * @since 2020-07-14
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoPO> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserInfoVO getUserInfoAll(UserPO user) {
        UserInfoPO userInfo = userInfoMapper.selectById(user.getId());
        if (userInfo == null) {
            throw new OERPException(40016);
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userInfo, userInfoVO);
        userInfoVO
                .setUsername(user.getUsername())
                .setPhoneNumber(user.getPhoneNumber());
        return userInfoVO;
    }

    @Override
    public Page<UserApplyExamVO> queryUserApplyExam(PageParamDTO pageParamDTO) {
        Page<UserApplyExamVO> page = new Page<>(pageParamDTO.getPageOn(), pageParamDTO.getPageSize());
        Integer userId = LocalUserStore.getLocalUser();
        userDAO.getUserApplyExam(page, userId, pageParamDTO.getKeyword());
        return page;
    }
}
