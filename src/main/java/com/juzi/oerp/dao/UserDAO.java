package com.juzi.oerp.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzi.oerp.model.vo.UserApplyExamVO;
import com.juzi.oerp.model.vo.UserInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Juzi
 * @date 2020/7/15 14:08
 */
public interface UserDAO {
    /**
     * 获取用户_分页
     *
     * @param page    分页参数
     * @param keyword 搜索关键词
     * @return 用户信息
     */
    IPage<UserInfoVO> getUserByPage(@Param("page") Page<UserInfoVO> page, @Param("keyword") String keyword);

    /**
     * 获取用户_根据用户 id
     *
     * @param userId 用户 id
     * @return 用户信息
     */
    UserInfoVO getUserByUserId(@Param("userId") Integer userId);

    IPage<UserApplyExamVO> getUserApplyExam(@Param("page") Page<UserApplyExamVO> page, @Param("userId") Integer userId,@Param("title")String title);
}
