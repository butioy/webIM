/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : webim

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-04-29 08:05:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for im_friend_group
-- ----------------------------
DROP TABLE IF EXISTS `im_friend_group`;
CREATE TABLE `im_friend_group` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '好友分组ID',
  `FRIEND_GROUP_NAME` varchar(50) NOT NULL COMMENT '好友分组名称',
  `OWNER` varchar(11) NOT NULL COMMENT '好友分组所有者账号',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for im_group
-- ----------------------------
DROP TABLE IF EXISTS `im_group`;
CREATE TABLE `im_group` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '群组ID',
  `GROUP_NAME` varchar(50) NOT NULL COMMENT '群组名称',
  `GROUP_CODE` varchar(11) NOT NULL COMMENT '群组CODE码',
  `OWNER` varchar(11) NOT NULL COMMENT '群组所有者账号',
  `PARENT_ID` int(10) NOT NULL DEFAULT '-1' COMMENT '父ID',
  `IMG` varchar(100) DEFAULT NULL COMMENT '分组图片地址',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for im_group_code
-- ----------------------------
DROP TABLE IF EXISTS `im_group_code`;
CREATE TABLE `im_group_code` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '群组ID',
  `GROUP_CODE` varchar(11) CHARACTER SET utf8mb4 NOT NULL COMMENT '群组CODE码',
  `IS_USED` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否使用（0:否, 1:是, 默认为0）',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for im_message_log
-- ----------------------------
DROP TABLE IF EXISTS `im_message_log`;
CREATE TABLE `im_message_log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '聊天记录ID',
  `FROM_USER` varchar(11) NOT NULL COMMENT '消息发送者账号',
  `TO_USER` varchar(11) NOT NULL COMMENT '消息接受者账号',
  `CONTENT` varchar(500) NOT NULL COMMENT '消息内容',
  `MSG_TYPE` tinyint(2) NOT NULL DEFAULT '1' COMMENT '消息类型(1:普通消息, 2:群消息, 默认为1)',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CONSUME_STATUS` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否消费(0:否, 1:是)',
  `CONSUME_TIME` datetime DEFAULT NULL COMMENT '消费时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for im_user
-- ----------------------------
DROP TABLE IF EXISTS `im_user`;
CREATE TABLE `im_user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `NICK_NAME` varchar(50) NOT NULL COMMENT '用户名',
  `REAL_NAME` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `ACCOUNT` varchar(11) NOT NULL COMMENT '用户账号',
  `PASSWORD` varchar(32) NOT NULL COMMENT '用户密码',
  `IMG` varchar(50) DEFAULT NULL COMMENT '头像地址',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_CODE` (`ACCOUNT`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for im_user_code
-- ----------------------------
DROP TABLE IF EXISTS `im_user_code`;
CREATE TABLE `im_user_code` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户账号id',
  `ACCOUNT` varchar(11) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户账号',
  `IS_USED` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否使用（0:否, 1:是, 默认为0）',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for im_user_friend
-- ----------------------------
DROP TABLE IF EXISTS `im_user_friend`;
CREATE TABLE `im_user_friend` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-好友关联表ID',
  `USER` varchar(11) NOT NULL COMMENT '用户账号',
  `FRIEND` varchar(11) NOT NULL COMMENT '好友账号',
  `FRIEND_GROUP_ID` int(10) NOT NULL COMMENT '所属好友分组ID',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for im_user_group
-- ----------------------------
DROP TABLE IF EXISTS `im_user_group`;
CREATE TABLE `im_user_group` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-群组关联表ID',
  `ACCOUNT` varchar(11) NOT NULL COMMENT '用户账号',
  `GROUP_CODE` varchar(11) NOT NULL COMMENT '群组CODE码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户-群组关联表';
