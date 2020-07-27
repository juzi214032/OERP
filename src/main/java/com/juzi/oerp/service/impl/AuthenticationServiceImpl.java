package com.juzi.oerp.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juzi.oerp.common.constant.CacheConstants;
import com.juzi.oerp.common.exception.AuthenticationException;
import com.juzi.oerp.common.exception.CaptchaException;
import com.juzi.oerp.common.store.LocalUserStore;
import com.juzi.oerp.mapper.UserInfoMapper;
import com.juzi.oerp.mapper.UserMapper;
import com.juzi.oerp.model.dto.*;
import com.juzi.oerp.model.dto.param.CheckImageCaptchaParamDTO;
import com.juzi.oerp.model.dto.param.CheckSMSCaptchaParamDTO;
import com.juzi.oerp.model.dto.param.SMSCaptchaParamDTO;
import com.juzi.oerp.model.po.UserInfoPO;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.model.vo.CaptchaVO;
import com.juzi.oerp.model.vo.UserInfoVO;
import com.juzi.oerp.model.vo.UserLoginVO;
import com.juzi.oerp.service.AuthenticationService;
import com.juzi.oerp.service.UserInfoService;
import com.juzi.oerp.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author Juzi
 * @date 2020/7/14 15:17
 */
@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private IAcsClient iAcsClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Resource
    private Cache smsCaptchaCache;

    @Resource
    private Cache imageCaptchaCache;

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserLoginVO loginByPassword(UserPasswordLoginDTO userPasswordLoginDTO) {
        UserPO userPO = new UserPO();
        userPO
                .setUsername(userPasswordLoginDTO.getUsername())
                .setPassword(SecureUtil.md5(userPasswordLoginDTO.getPassword()));

        UserPO user = userMapper.selectOne(new QueryWrapper<>(userPO));

        if (user == null || user.getStatus() == 1) {
            throw new AuthenticationException(40002);
        }

        String token = JWTUtils.createToken(user.getId());
        UserInfoVO userInfoVO = userInfoService.getUserInfoAll(user);
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO
                .setToken(token)
                .setUserInfo(userInfoVO);
        return userLoginVO;
    }

    @Override
    public UserLoginVO loginBySMS(UserSMSLoginDTO userSMSLoginDTO) {
        String phoneNumber = userSMSLoginDTO.getPhoneNumber();
        this.checkPhoneNumberValidated(phoneNumber);

        LambdaQueryWrapper<UserPO> query = new LambdaQueryWrapper<UserPO>().eq(UserPO::getPhoneNumber, phoneNumber);
        UserPO user = userMapper.selectOne(query);

        if (user == null || user.getStatus() == 1) {
            throw new AuthenticationException(40002);
        }

        String token = JWTUtils.createToken(user.getId());
        UserInfoVO userInfoVO = userInfoService.getUserInfoAll(user);
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO
                .setToken(token)
                .setUserInfo(userInfoVO);
        return userLoginVO;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public UserLoginVO registion(UserRegistionDTO userRegistionDTO) {
        // 检查手机号是否已经过验证
        this.checkPhoneNumberValidated(userRegistionDTO.getPhoneNumber());
        // 检查手机号是否可用
        this.checkPhoneNumberUsed(userRegistionDTO.getPhoneNumber());

        // 插入用户账号
        UserPO newUserPO = new UserPO();
        newUserPO
                .setPhoneNumber(userRegistionDTO.getPhoneNumber())
                .setUsername(userRegistionDTO.getUsername())
                .setPassword(SecureUtil.md5(userRegistionDTO.getPassword()));
        userMapper.insert(newUserPO);

        // 插入用户信息
        UserInfoPO newUserInfoPO = new UserInfoPO();
        newUserInfoPO
                .setUserId(newUserPO.getId());
        userInfoMapper.insert(newUserInfoPO);

        // 删除短信验证码缓存
        smsCaptchaCache.evict(userRegistionDTO.getPhoneNumber());

        // 进行登录操作
        UserPasswordLoginDTO userPasswordLoginDTO = new UserPasswordLoginDTO();
        userPasswordLoginDTO
                .setUsername(userRegistionDTO.getUsername())
                .setPassword(userRegistionDTO.getPassword());
        return this.loginByPassword(userPasswordLoginDTO);
    }

    @Override
    public CaptchaVO getImageCaptcha() {
        // 验证码对应 id
        String captchaId = IdUtil.objectId();
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 70);

        // 将验证码存入缓存
        String imageCaptcha = lineCaptcha.getCode();
        log.debug("本次生成图片验证码为：{}", imageCaptcha);
        imageCaptchaCache.put(captchaId, imageCaptcha);
        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO
                .setCaptchaId(captchaId)
                .setCaptchaImageBase64("data:image/png;base64," + lineCaptcha.getImageBase64());
        return captchaVO;
    }

    @Override
    public void checkImageCaptcha(CheckImageCaptchaParamDTO checkImageCaptchaParamDTO) {
        String reallyImageCaptcha = imageCaptchaCache.get(checkImageCaptchaParamDTO.getCaptchaId(), String.class);
        if (StringUtils.isEmpty(reallyImageCaptcha)) {
            throw new AuthenticationException(40000);
        }

        if (!reallyImageCaptcha.equals(checkImageCaptchaParamDTO.getCaptcha())) {
            throw new AuthenticationException(40004);
        }

        imageCaptchaCache.put(checkImageCaptchaParamDTO.getCaptchaId(), CacheConstants.CAPTCHA_CHECKED);
    }

    @Override
    public void getSMSCaptcha(SMSCaptchaParamDTO smsCaptchaParamDTO) throws JsonProcessingException {
        // 生成短信验证码
        String smsCaptcha = RandomUtil.randomNumbers(6);
        log.debug("本次生成短信验证码为：{}", smsCaptcha);

        String imageCaptcha = imageCaptchaCache.get(smsCaptchaParamDTO.getCaptchaId(), String.class);
        if (StringUtils.isEmpty(imageCaptcha)) {
            throw new CaptchaException(40001);
        }

        if (!CacheConstants.CAPTCHA_CHECKED.equals(imageCaptcha)) {
            throw new CaptchaException(40005);
        }

        // 将短信验证码放入缓存
        smsCaptchaCache.put(smsCaptchaParamDTO.getPhoneNumber(), smsCaptcha);
        // 将图片验证码从缓存中清除
        imageCaptchaCache.evict(smsCaptchaParamDTO.getCaptchaId());

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", smsCaptchaParamDTO.getPhoneNumber());
        request.putQueryParameter("SignName", "ABC商城");
        request.putQueryParameter("TemplateCode", "SMS_196641887");
        request.putQueryParameter("TemplateParam", objectMapper.writeValueAsString(MapUtil.builder("code", smsCaptcha).build()));
        try {
            iAcsClient.getCommonResponse(request);
        } catch (ClientException e) {
            throw new AuthenticationException(50001, e);
        }
    }

    @Override
    public void checkSMSCaptcha(CheckSMSCaptchaParamDTO checkSMSCaptchaParamDTO) {
        String reallySMSCpatcha = smsCaptchaCache.get(checkSMSCaptchaParamDTO.getPhoneNumber(), String.class);
        if (StringUtils.isEmpty(reallySMSCpatcha)) {
            throw new AuthenticationException(40000);
        }

        if (!reallySMSCpatcha.equals(checkSMSCaptchaParamDTO.getCaptcha())) {
            throw new AuthenticationException(40004);
        }

        smsCaptchaCache.put(checkSMSCaptchaParamDTO.getPhoneNumber(), CacheConstants.CAPTCHA_CHECKED);
    }

    /**
     * 检测手机号是否已经被使用
     *
     * @param phoneNumber 手机号
     */
    private void checkPhoneNumberUsed(String phoneNumber) {
        UserPO user = userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getPhoneNumber, phoneNumber));
        // 手机号已被注册
        if (user != null) {
            throw new AuthenticationException(40001);
        }
    }

    /**
     * 检测手机号是否经过验证
     *
     * @param phoneNumber 手机号
     */
    private void checkPhoneNumberValidated(String phoneNumber) {
        String reallySMSCaptcha = smsCaptchaCache.get(phoneNumber, String.class);
        if (StringUtils.isEmpty(reallySMSCaptcha) || !CacheConstants.CAPTCHA_CHECKED.equals(reallySMSCaptcha)) {
            throw new AuthenticationException(40006);
        }
    }

    @Override
    public void updatePhoneNumber(String phoneNumber) {
        checkPhoneNumberValidated(phoneNumber);

        UserPO userPO=userMapper.selectById(LocalUserStore.getLocalUser());
        userPO.setPhoneNumber(phoneNumber);
        userMapper.updateById(userPO);
    }

    @Override
    public void updatePassword(ChangePasswordDTO changePasswordDTO) {
        UserPO userPO = userMapper.selectById(LocalUserStore.getLocalUser());
        String oldPassword = userPO.getPassword();
        //传过来的密码加密
        String dtoNewPassword = SecureUtil.md5(changePasswordDTO.getNewPassword());
        String dtoOldPassword = SecureUtil.md5(changePasswordDTO.getOldPassword());
        if (!oldPassword.equals(dtoOldPassword)) {
            throw new AuthenticationException(40011);
        }

        userPO.setPassword(dtoNewPassword);
        userMapper.updateById(userPO);
    }

    @Override
    public void updatePassword(ChangePasswordByPhoneNumDTO changePasswordByPhoneNumDTO) {
        this.checkPhoneNumberValidated(changePasswordByPhoneNumDTO.getPhoneNumber());
        UserPO userPO = userMapper.selectById(LocalUserStore.getLocalUser());
        //传过来的密码加密
        String dtoNewPassword= SecureUtil.md5(changePasswordByPhoneNumDTO.getNewPassword());
        userPO.setPassword(dtoNewPassword);
        userMapper.updateById(userPO);
    }

    @Override
    public void resetPassword(RetrieveUserDTO retrieveUserDTO) {
        //检测手机号是否经过验证
        this.checkPhoneNumberValidated(retrieveUserDTO.getPhoneNumber());

        String newPassword = retrieveUserDTO.getNewPassword();
        UserPO userPO = new UserPO();
        userPO.setPassword(SecureUtil.md5(newPassword));
        userMapper.updateById(userPO);
    }
}
