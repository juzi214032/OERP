package com.juzi.oerp.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzi.oerp.dao.UserDAO;
import com.juzi.oerp.mapper.UserInfoMapper;
import com.juzi.oerp.mapper.UserMapper;
import com.juzi.oerp.model.dto.CreateUserDTO;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.dto.UpdateUserDTO;
import com.juzi.oerp.model.po.UserInfoPO;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.model.vo.UserInfoVO;
import com.juzi.oerp.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Juzi
 * @since 2020-07-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Page<UserInfoVO> getUserByPage(PageParamDTO pageParamDTO) {
        Page<UserInfoVO> page = new Page<>(pageParamDTO.getPageOn(), pageParamDTO.getPageSize());
        userDAO.getUserByPage(page);
        return page;
    }

    @Override
    public UserInfoVO getUserByUserId(Integer userId) {
        return userDAO.getUserByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteUserByUserId(Integer userId) {
        userMapper.deleteById(userId);
        userInfoMapper.deleteById(userId);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void createUser(CreateUserDTO createUserDTO) {
        UserPO userPO = new UserPO();
        UserInfoPO userInfoPO = new UserInfoPO();

        BeanUtils.copyProperties(createUserDTO,userPO);
        BeanUtils.copyProperties(createUserDTO,userInfoPO);

        userMapper.insert(userPO);

        userInfoPO.setUserId(userPO.getId());
        userInfoMapper.insert(userInfoPO);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateUser(UpdateUserDTO updateUserDTO) {
        UserPO userPO = new UserPO();
        UserInfoPO userInfoPO = new UserInfoPO();

        BeanUtils.copyProperties(updateUserDTO,userPO);
        BeanUtils.copyProperties(updateUserDTO,userInfoPO);

        userMapper.updateById(userPO);

        userInfoPO.setUserId(userPO.getId());
        userInfoMapper.updateById(userInfoPO);
    }
}
