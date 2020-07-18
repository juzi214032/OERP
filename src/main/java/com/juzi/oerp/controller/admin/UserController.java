package com.juzi.oerp.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzi.oerp.model.dto.CreateUserDTO;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.dto.UpdateUserDTO;
import com.juzi.oerp.model.vo.UserInfoVO;
import com.juzi.oerp.model.vo.response.CreateResponseVO;
import com.juzi.oerp.model.vo.response.DeleteResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juzi
 * @date 2020/7/15 12:09
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户_分页
     *
     * @param pageParamDTO 分页参数
     * @return 用户信息
     */
    @GetMapping
    public ResponseVO<Page<UserInfoVO>> getUserByPage(PageParamDTO pageParamDTO) {
        Page<UserInfoVO> result = userService.getUserByPage(pageParamDTO);
        return new ResponseVO<>(result);
    }

    /**
     * 获取用户_根据 userId
     *
     * @param userId 用户 id
     * @return 用户信息
     */
    @GetMapping("/{userId}")
    public ResponseVO<UserInfoVO> getUserByUserId(@PathVariable Integer userId) {
        UserInfoVO result = userService.getUserByUserId(userId);
        return new ResponseVO<>(result);
    }

    /**
     * 删除用户_根据 userId
     *
     * @param userId 用户 id
     * @return 删除成功信息
     */
    @DeleteMapping("/{userId}")
    public ResponseVO<Object> deleteUserByUserId(@PathVariable Integer userId) {
        userService.deleteUserByUserId(userId);
        return new DeleteResponseVO();
    }

    /**
     * 新增用户
     *
     * @param createUserDTO 用户信息
     * @return 新增成功信息
     */
    @PostMapping
    public ResponseVO<Object> createUser(@RequestBody CreateUserDTO createUserDTO) {
        userService.createUser(createUserDTO);
        return new CreateResponseVO();
    }

    /**
     * 更新用户信息
     *
     * @param updateUserDTO 更新用户参数
     * @return 更新成功信息
     */
    @PutMapping
    public ResponseVO<Object> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        userService.updateUser(updateUserDTO);
        return new CreateResponseVO();
    }
}
