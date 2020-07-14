// package com.juzi.oerp.dao;
//
// import cn.hutool.crypto.SecureUtil;
// import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
// import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
// import com.juzi.oerp.model.UserDO;
// import com.juzi.oerp.model.UserInfoDO;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.annotation.Rollback;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.transaction.annotation.Transactional;
//
// import java.time.LocalDateTime;
// import java.util.List;
//
// @Rollback
// @Transactional
// @SpringBootTest
// @EnableAutoConfiguration
// @ExtendWith(SpringExtension.class)
// class UserInfoMapperTest {
//
//     @Autowired
//     private UserMapper userMapper;
//
//     @Autowired
//     private UserInfoMapper userInfoMapper;
//
//     /**
//      * 查询所有 user 信息
//      */
//     @Test
//     void selectList() {
//         List<UserInfoDO> userInfoDOS = userInfoMapper.selectList(null);
//         userInfoDOS.forEach(System.out::println);
//     }
//
//     /**
//      * 新增用户测试
//      */
//     @Test
//     void insert() {
//         UserDO userDO = new UserDO();
//         userDO.setUsername("test").setPassword(SecureUtil.md5("test"));
//         userMapper.insert(userDO);
//
//         UserInfoDO userInfoDO = new UserInfoDO();
//         userInfoDO
//                 .setUserId(userDO.getId())
//                 .setNickname("测试昵称")
//                 .setName("测试姓名")
//                 .setGender(1)
//                 .setPhoneNo("15678888888")
//                 .setIdentityNo("123456789012345678")
//                 .setBirthday(LocalDateTime.now());
//         userInfoMapper.insert(userInfoDO);
//
//         selectList();
//     }
//
//     /**
//      * 删除用户信息
//      */
//     @Test
//     void delete(){
//         userMapper.delete(new LambdaQueryWrapper<UserDO>().eq(UserDO::getId,1));
//         userInfoMapper.delete(new LambdaQueryWrapper<UserInfoDO>().eq(UserInfoDO::getUserId,1));
//         selectList();
//     }
//
//     /**
//      * 更新用户信息
//      */
//     @Test
//     void update(){
//         UserInfoDO userInfoDO = new UserInfoDO();
//         userInfoDO.setUserId(1).setNickname("测试昵称").setName("测试姓名");
//         userInfoMapper.updateById(userInfoDO);
//         selectList();
//     }
//
//     /**
//      * 分页查询
//      */
//     @Test
//     void page(){
//         Page<UserInfoDO> page = new Page<>();
//         Page<UserInfoDO> pageResult = userInfoMapper.selectPage(page, null);
//         System.out.println("总条数"+pageResult.getTotal());
//         pageResult.getRecords().forEach(System.out::println);
//     }
// }