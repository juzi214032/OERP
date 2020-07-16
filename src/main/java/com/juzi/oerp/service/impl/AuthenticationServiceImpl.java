package com.juzi.oerp.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzi.oerp.common.exception.AuthenticationException;
import com.juzi.oerp.mapper.UserInfoMapper;
import com.juzi.oerp.mapper.UserMapper;
import com.juzi.oerp.model.dto.UserLoginDTO;
import com.juzi.oerp.model.dto.UserRegistionDTO;
import com.juzi.oerp.model.po.UserInfoPO;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.model.vo.CaptchaVO;
import com.juzi.oerp.model.vo.UserLoginVO;
import com.juzi.oerp.service.AuthenticationService;
import com.juzi.oerp.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author Juzi
 * @date 2020/7/14 15:17
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        UserPO userPO = new UserPO();
        userPO
                .setUsername(userLoginDTO.getUsername())
                .setPassword(SecureUtil.md5(userLoginDTO.getPassword()));

        UserPO user = userMapper.selectOne(new QueryWrapper<>(userPO));

        if (user == null || user.getStatus() == 1) {
            throw new AuthenticationException();
        }

        String token = JWTUtils.createToken(user.getId());
        UserInfoPO userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfoPO>().eq(UserInfoPO::getUserId, user.getId()));
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO
                .setToken(token)
                .setUserInfo(userInfo);
        return userLoginVO;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public UserLoginVO registion(UserRegistionDTO userRegistionDTO) {
        UserPO oldUserPO =
                userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getUsername, userRegistionDTO.getUsername()));

        // 用户名重复
        if (oldUserPO != null) {
            throw new AuthenticationException();
        }

        // 插入用户账号
        UserPO newUserPO = new UserPO();
        newUserPO
                .setUsername(userRegistionDTO.getUsername())
                .setPassword(SecureUtil.md5(userRegistionDTO.getPassword()));
        userMapper.insert(newUserPO);

        // 插入用户信息
        UserInfoPO newUserInfoPO = new UserInfoPO();
        newUserInfoPO
                .setUserId(newUserPO.getId())
                .setNickname(userRegistionDTO.getNickname());
        userInfoMapper.insert(newUserInfoPO);

        // 进行登录操作
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO
                .setUsername(userRegistionDTO.getUsername())
                .setPassword(userRegistionDTO.getPassword());
        return this.login(userLoginDTO);
    }

    @Override
    public CaptchaVO getImageCaptcha() {
        // 验证码对应 id
        String captchaId = IdUtil.objectId();
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 70);
        Cache captchaCache = cacheManager.getCache("CAPTCHA_CACHE");

        // 将验证码存入缓存
        Assert.notNull(captchaCache,"缓存加载异常，请检查缓存配置");
        captchaCache.put(captchaId, lineCaptcha.getCode());

        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO
                .setCaptchaId(captchaId)
                .setCaptchaImageBase64(lineCaptcha.getImageBase64());
        return captchaVO;
    }

    @Override
    public void getSMSCaptcha(String phoneNumber) {
        // todo 发送短信逻辑
    }

}
