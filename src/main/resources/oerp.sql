/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 120.78.139.130:3306
 Source Schema         : oerl

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 01/08/2020 09:55:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
                         `id`          int(11)                                                  NOT NULL AUTO_INCREMENT,
                         `title`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '考试名称',
                         `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '描述',
                         `detail`      longtext CHARACTER SET utf8 COLLATE utf8_general_ci      NULL COMMENT '考试页面信息：富文本',
                         `image_url`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '图片 url',
                         `begin_time`  timestamp(0)                                             NOT NULL COMMENT '报名开始时间',
                         `end_time`    timestamp(0)                                             NOT NULL COMMENT '报名截止时间',
                         `price`       decimal(10, 2)                                           NOT NULL COMMENT '报名费用',
                         `create_time` timestamp(0)                                             NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                         `update_time` timestamp(0)                                             NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10017
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '考试信息'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exam_place
-- ----------------------------
DROP TABLE IF EXISTS `exam_place`;
CREATE TABLE `exam_place`
(
    `id`            int(11)                                                 NOT NULL AUTO_INCREMENT COMMENT '主键',
    `exam_time_id`  int(11)                                                 NOT NULL COMMENT '考试时间 id',
    `exam_place`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试 地点',
    `people_number` int(11)                                                 NOT NULL COMMENT '最多报名人数。-1无限制',
    `create_time`   timestamp(0)                                            NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
    `update_time`   timestamp(0)                                            NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 80669
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '考试时间对应的考试地点'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exam_time
-- ----------------------------
DROP TABLE IF EXISTS `exam_time`;
CREATE TABLE `exam_time`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `exam_id`     int(11)      NOT NULL COMMENT '考试id',
    `exam_time`   timestamp(0) NOT NULL COMMENT '考试时间',
    `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
    `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 32216
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '考试对应的考试时间，一对多'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`           int(10) UNSIGNED                                       NOT NULL AUTO_INCREMENT,
    `username`     varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '账号',
    `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci    NOT NULL COMMENT '手机号',
    `password`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
    `role`         tinyint(2) UNSIGNED ZEROFILL                           NOT NULL DEFAULT 00 COMMENT '角色：0普通用户/1管理员',
    `status`       tinyint(2) UNSIGNED ZEROFILL                           NOT NULL DEFAULT 00 COMMENT '账号状态：0正常/1冻结',
    `create_time`  timestamp(0)                                           NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
    `update_time`  timestamp(0)                                           NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10008
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户账号'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_exam
-- ----------------------------
DROP TABLE IF EXISTS `user_exam`;
CREATE TABLE `user_exam`
(
    `id`            int(11)                      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`       int(11)                      NOT NULL COMMENT '用户id',
    `exam_place_id` int(11)                      NOT NULL COMMENT '考试地点id',
    `status`        tinyint(2) UNSIGNED ZEROFILL NOT NULL DEFAULT 00 COMMENT '报名状态：\r\n0 - 已申请\r\n1 - 已支付\r\n2 - 审核通过\r\n3 - 审核未通过',
    `create_time`   timestamp(0)                 NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
    `update_time`   timestamp(0)                 NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 299264
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户考试报名信息'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`
(
    `user_id`     int(11)                                                 NOT NULL COMMENT '用户id',
    `nickname`    varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '昵称',
    `avatar_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'https://656e-env-9eb476-1258886794.tcb.qcloud.la/images/index-list/avatar/1.jpg?sign=cd2c2287be1fd4328f0510627253742a&t=1594641803' COMMENT '头像',
    `name`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
    `photo_url`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片url',
    `gender`      tinyint(2) UNSIGNED ZEROFILL                            NULL DEFAULT 00 COMMENT '性别：0未知/1男/2女',
    `identity_no` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT NULL COMMENT '身份证号码',
    `birthday`    timestamp(0)                                            NULL DEFAULT NULL COMMENT '生日',
    `school`      varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT '重庆邮电大学' COMMENT '学校',
    `education`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
    `create_time` timestamp(0)                                            NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
    `update_time` timestamp(0)                                            NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    PRIMARY KEY (`user_id`) USING BTREE,
    UNIQUE INDEX `identity_no` (`identity_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
