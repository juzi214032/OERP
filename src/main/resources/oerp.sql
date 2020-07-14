/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL8
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3307
 Source Schema         : oerp

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 14/07/2020 14:42:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` tinyint(2) UNSIGNED ZEROFILL NOT NULL DEFAULT 00 COMMENT '角色：0普通用户/1管理员',
  `status` tinyint(2) UNSIGNED ZEROFILL NOT NULL DEFAULT 00 COMMENT '账号状态：0正常/1冻结',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'juzi', '0e9a512ca08cc66fea479658cda55c01', 01, 00, '2020-07-13 20:18:21', '2020-07-13 20:18:21');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641803' COMMENT '头像',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` tinyint(2) UNSIGNED ZEROFILL NULL DEFAULT 00 COMMENT '性别：0未知/1男/2女',
  `identity_no` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `birthday` timestamp(0) NULL DEFAULT NULL COMMENT '生日',
  `phone_no` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '桔子', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641803', '鞠青松', 00, '511199811009898', '1994-10-13 20:19:49', '15687899843');

SET FOREIGN_KEY_CHECKS = 1;
