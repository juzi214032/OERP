package com.juzi.oerp.service.impl;

import com.juzi.oerp.model.po.UserInfoPO;
import com.juzi.oerp.dao.UserInfoDAO;
import com.juzi.oerp.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Juzi
 * @since 2020-07-14
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDAO, UserInfoPO> implements UserInfoService {

}
