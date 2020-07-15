package com.juzi.oerp.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzi.oerp.model.vo.UserInfoVO;
import org.apache.ibatis.annotations.Param;

/**
 * @author Juzi
 * @date 2020/7/15 14:08
 */
public interface UserDAO {
    IPage<UserInfoVO> getUserByPage(Page<UserInfoVO> page);

    UserInfoVO getUserByUserId(@Param("userId") Integer userId);
}
