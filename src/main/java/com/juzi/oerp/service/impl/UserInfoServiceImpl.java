package com.juzi.oerp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzi.oerp.mapper.UserInfoMapper;
import com.juzi.oerp.model.po.UserInfoPO;
import com.juzi.oerp.service.UserInfoService;
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

}
