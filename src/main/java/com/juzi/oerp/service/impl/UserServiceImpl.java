package com.juzi.oerp.service.impl;

import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.dao.UserDAO;
import com.juzi.oerp.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserDAO, UserPO> implements UserService {

}
