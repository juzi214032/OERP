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

 Date: 16/07/2020 11:05:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试名称',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `detail` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '考试页面信息：富文本',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片 url',
  `begin_time` timestamp(0) NOT NULL COMMENT '报名开始时间',
  `end_time` timestamp(0) NOT NULL COMMENT '报名截止时间',
  `people_number` int(11) NOT NULL COMMENT '最多可报名多少人：-1 无限制',
  `price` decimal(10, 2) NOT NULL COMMENT '报名费用',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考试信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------

-- ----------------------------
-- Table structure for exam_place
-- ----------------------------
DROP TABLE IF EXISTS `exam_place`;
CREATE TABLE `exam_place`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `exam_time_id` int(11) NOT NULL COMMENT '考试时间 id',
  `exam_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试 地点',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考试时间对应的考试地点' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_place
-- ----------------------------

-- ----------------------------
-- Table structure for exam_time
-- ----------------------------
DROP TABLE IF EXISTS `exam_time`;
CREATE TABLE `exam_time`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `exam_id` int(11) NOT NULL COMMENT '考试id',
  `exam_time` timestamp(0) NOT NULL COMMENT '考试时间',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考试对应的考试时间，一对多' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_time
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户账号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'juzi', '0e9a512ca08cc66fea479658cda55c01', 01, 00, '2020-07-13 20:18:21', '2020-07-13 20:18:21');

-- ----------------------------
-- Table structure for user_exam
-- ----------------------------
DROP TABLE IF EXISTS `user_exam`;
CREATE TABLE `user_exam`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `exam_id` int(11) NOT NULL COMMENT '考试id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(2) UNSIGNED ZEROFILL NOT NULL COMMENT '报名状态：\r\n0 - 已申请\r\n1 - 已支付\r\n2 - 审核通过\r\n3 - 审核未通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户考试报名信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_exam
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641803' COMMENT '头像',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `photo_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片url',
  `gender` tinyint(2) UNSIGNED ZEROFILL NULL DEFAULT 00 COMMENT '性别：0未知/1男/2女',
  `identity_no` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `birthday` timestamp(0) NULL DEFAULT NULL COMMENT '生日',
  `phone_no` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `education` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '桔子', 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641803', '鞠青松', NULL, 00, '511199811009898', '1994-10-13 20:19:49', '15687899843', NULL, '2020-07-14 15:27:39', '2020-07-14 15:27:39');

SET FOREIGN_KEY_CHECKS = 1;
