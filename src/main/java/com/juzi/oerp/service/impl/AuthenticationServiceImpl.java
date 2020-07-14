package com.juzi.oerp.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzi.oerp.common.exception.AuthenticationException;
import com.juzi.oerp.dao.UserDAO;
import com.juzi.oerp.dao.UserInfoDAO;
import com.juzi.oerp.model.dto.UserLoginDTO;
import com.juzi.oerp.model.dto.UserRegistionDTO;
import com.juzi.oerp.model.po.UserInfoPO;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.model.vo.UserLoginVO;
import com.juzi.oerp.service.AuthenticationService;
import com.juzi.oerp.util.JWTUtils;
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
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        UserPO userPO = new UserPO();
        userPO
                .setUsername(userLoginDTO.getUsername())
                .setPassword(SecureUtil.md5(userLoginDTO.getPassword()));

        UserPO user = userDAO.selectOne(new QueryWrapper<UserPO>(userPO));

        if (user == null || user.getStatus() == 1) {
            throw new AuthenticationException();
        }

        String token = JWTUtils.createToken(user.getId());
        UserInfoPO userInfo = userInfoDAO.selectOne(new LambdaQueryWrapper<UserInfoPO>().eq(UserInfoPO::getUserId, user.getId()));
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO
                .setToken(token)
                .setUserInfo(userInfo);
        return userLoginVO;
    }

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
