package com.juzi.oerp.service;

import com.juzi.oerp.model.po.UserInfoPO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.model.vo.UserInfoVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Juzi
 * @since 2020-07-14
 */
public interface UserInfoService extends IService<UserInfoPO> {
    /**
     * 获取用户完整信息
     *
     * @param userPO 用户账号手机号信息
     * @return 用户完整信息
     */
    UserInfoVO getUserInfoAll(UserPO userPO);
}
