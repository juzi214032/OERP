package com.juzi.oerp.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.juzi.oerp.common.exception.AuthenticationException;
import com.juzi.oerp.dao.UserDAO;
import com.juzi.oerp.dao.UserInfoDAO;
import com.juzi.oerp.model.dto.UserRegistionDTO;
import com.juzi.oerp.model.po.UserInfoPO;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Juzi
 * @date 2020/7/14 15:17
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void registion(UserRegistionDTO userRegistionDTO) {
        UserPO oldUserPO =
                userDAO.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getUsername, userRegistionDTO.getUsername()));

        // 用户名重复
        if (oldUserPO != null) {
            throw new AuthenticationException();
        }

        // 插入用户账号
        UserPO newUserPO = new UserPO();
        newUserPO
                .setUsername(userRegistionDTO.getUsername())
                .setPassword(SecureUtil.md5(userRegistionDTO.getPassword()));
        userDAO.insert(newUserPO);

        // 插入用户信息
        UserInfoPO newUserInfoPO = new UserInfoPO();
        newUserInfoPO
                .setUserId(newUserPO.getId())
                .setNickname(userRegistionDTO.getNickname());
        userInfoDAO.insert(newUserInfoPO);

    }
}
