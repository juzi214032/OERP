package com.juzi.oerp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.juzi.oerp.model.dto.CreateUserDTO;
import com.juzi.oerp.model.dto.PageParamDTO;
import com.juzi.oerp.model.dto.UpdateUserDTO;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.model.vo.UserInfoVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Juzi
 * @since 2020-07-15
 */
public interface UserService extends IService<UserPO> {
    /**
     * 获取用户_分页
     *
     * @param pageParamDTO 分页参数
     * @return 分页用户信息
     */
    Page<UserInfoVO> getUserByPage(PageParamDTO pageParamDTO);

    /**
     * 获取用户_根据 userId
     * @param userId 用户 id
     * @return 单条用户信息
     */
    UserInfoVO getUserByUserId(Integer userId);

    /**
     * 删除用户_根据 userId
     * @param userId 用户 id
     */
    void deleteUserByUserId(Integer userId);

    /**
     * 新增用户
     * @param createUserDTO 用户信息
     */
    void createUser(CreateUserDTO createUserDTO);

    /**
     * 修改用户信息
     * @param updateUserDTO 用户信息
     */
    void updateUser(UpdateUserDTO updateUserDTO);
}
