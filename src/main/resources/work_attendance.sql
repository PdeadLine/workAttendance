/*
Navicat MySQL Data Transfer

Source Server         : linux_mysql
Source Server Version : 50173
Source Host           : 192.168.1.188:3306
Source Database       : work_attendance

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-06-25 21:39:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attend`
-- ----------------------------
DROP TABLE IF EXISTS `attend`;
CREATE TABLE `attend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '打卡人',
  `attend_date` date NOT NULL COMMENT '打卡日期',
  `attend_week` tinyint(2) NOT NULL COMMENT '星期几打卡',
  `attend_moring` time DEFAULT NULL COMMENT '早打卡时间',
  `attend_evening` time DEFAULT NULL COMMENT '晚打卡时间',
  `absence` int(10) DEFAULT NULL COMMENT '缺勤时间',
  `attend_status` tinyint(2) NOT NULL COMMENT '考勤状态1：正常 2：异常',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attend
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `real_name` varchar(20) NOT NULL COMMENT '真实名称',
  `head_image` varchar(100) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张5', '123456', '1383838438', '资讯管理员', null);
INSERT INTO `user` VALUES ('2', '张5', '123456', '1383838438', '资讯管理员', null);
INSERT INTO `user` VALUES ('3', '张5', '123456', '1383838438', '资讯管理员', null);
INSERT INTO `user` VALUES ('4', '张3', '123456', '1383838438', '资讯管理员', null);
INSERT INTO `user` VALUES ('5', '张3', '123456', '1383838438', '资讯管理员', null);
INSERT INTO `user` VALUES ('6', '张3', '123456', '1383838438', '资讯管理员', null);
