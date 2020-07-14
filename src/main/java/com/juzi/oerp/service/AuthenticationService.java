package com.juzi.oerp.service;

import com.juzi.oerp.model.dto.UserRegistionDTO;

/**
 * 认证服务
 *
 * @author Juzi
 * @date 2020/7/14 15:16
 */
public interface AuthenticationService {
    /**
     * 用户注册
     * @param userRegistionDTO 注册信息
     */
     void registion(UserRegistionDTO userRegistionDTO);
}
