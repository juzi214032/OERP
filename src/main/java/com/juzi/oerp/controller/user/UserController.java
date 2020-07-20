package com.juzi.oerp.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.juzi.oerp.common.store.LocalUserStore;
import com.juzi.oerp.model.dto.UpdateUserInfoDTO;
import com.juzi.oerp.model.po.UserInfoPO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.model.vo.response.UpdatedResponseVO;
import com.juzi.oerp.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juzi
 * @date 2020/7/19 20:48
 */
@Api(tags = "用户信息")
@RequestMapping("/user")
@RestController("userUserController")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    @ApiOperation(value = "个人信息", notes = "获取当前已登录用户的个人信息")
    public ResponseVO<UserInfoPO> getUserInfo() {
        Integer userId = LocalUserStore.getLocalUser();
        UserInfoPO userInfo = userInfoService.getOne(new LambdaQueryWrapper<UserInfoPO>().eq(UserInfoPO::getUserId, userId));
        return new ResponseVO<>(userInfo);
    }

    @PutMapping
    @ApiOperation(value = "修改个人信息")
    public UpdatedResponseVO updateUserInfo(@RequestBody UpdateUserInfoDTO updateUserInfoDTO) {
        Integer userId = LocalUserStore.getLocalUser();
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setUserId(userId);
        BeanUtils.copyProperties(updateUserInfoDTO, userInfoPO);

        userInfoService.updateById(userInfoPO);
        return new UpdatedResponseVO();
    }

}
