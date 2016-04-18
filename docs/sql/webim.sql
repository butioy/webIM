/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : webim

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-02-01 07:29:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for im_friend_group
-- ----------------------------
DROP TABLE IF EXISTS `im_friend_group`;
CREATE TABLE `im_friend_group` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '好友分组ID',
  `NAME` varchar(50) NOT NULL COMMENT '好友分组名称',
  `OWNER_ID` int(10) NOT NULL COMMENT '好友分组所有者ID',
  `OWNER_CODE` varchar(32) NOT NULL COMMENT '好友分组所有者CODE码',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of im_friend_group
-- ----------------------------
INSERT INTO `im_friend_group` VALUES ('1', '测试分组1', '1', 'e35a5c01e7ed476eae86b2941acd0e8a', '测试分组1', '2016-01-31 10:47:52', null);
INSERT INTO `im_friend_group` VALUES ('2', '测试分组2', '2', 'c69951adac1748ab96da50189ccbbd13', '测试分组2', '2016-01-31 12:37:58', null);

-- ----------------------------
-- Table structure for im_group
-- ----------------------------
DROP TABLE IF EXISTS `im_group`;
CREATE TABLE `im_group` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '群组ID',
  `NAME` varchar(50) NOT NULL COMMENT '群组名称',
  `OWNER_ID` int(10) NOT NULL COMMENT '所有者ID',
  `OWNER_CODE` varchar(32) NOT NULL COMMENT '所有者CODE码',
  `PARENT_ID` int(10) NOT NULL DEFAULT '-1' COMMENT '父ID',
  `IMG` varchar(100) DEFAULT NULL COMMENT '分组图片地址',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of im_group
-- ----------------------------
INSERT INTO `im_group` VALUES ('1', '测试群组1', '1', '', '-1', null, null, '2016-01-31 12:49:40', null);
INSERT INTO `im_group` VALUES ('2', '测试群组1_01', '1', '', '1', null, null, '2016-01-31 12:50:06', null);
INSERT INTO `im_group` VALUES ('3', '测试群组2', '1', '', '-1', null, null, '2016-01-31 12:50:15', null);
INSERT INTO `im_group` VALUES ('4', '测试群组2_01', '1', '', '3', null, null, '2016-01-31 12:50:23', null);
INSERT INTO `im_group` VALUES ('5', '测试群组3', '2', '', '-1', null, null, '2016-01-31 12:50:40', null);
INSERT INTO `im_group` VALUES ('6', '测试群组3_01', '2', '', '5', null, null, '2016-01-31 12:50:54', null);
INSERT INTO `im_group` VALUES ('7', '测试群组1_02', '1', '', '1', null, null, '2016-01-31 13:09:27', null);

-- ----------------------------
-- Table structure for im_message_log
-- ----------------------------
DROP TABLE IF EXISTS `im_message_log`;
CREATE TABLE `im_message_log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '聊天记录ID',
  `FROM_USER_CODE` varchar(42) NOT NULL COMMENT '消息发送者CODE',
  `TO_USER_CODE` varchar(42) NOT NULL COMMENT '消息接受者CODE',
  `CONTENT` varchar(500) NOT NULL COMMENT '消息内容',
  `TYPE` tinyint(2) NOT NULL DEFAULT '1' COMMENT '消息类型(1:普通消息, 2:群消息, 默认为1)',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CONSUME_STATUS` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否消费(0:否, 1:是)',
  `CONSUME_TIME` datetime DEFAULT NULL COMMENT '消费时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of im_message_log
-- ----------------------------

-- ----------------------------
-- Table structure for im_user
-- ----------------------------
DROP TABLE IF EXISTS `im_user`;
CREATE TABLE `im_user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USER_NAME` varchar(50) NOT NULL COMMENT '用户名',
  `REAL_NAME` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `USER_CODE` varchar(32) NOT NULL COMMENT '用户代码',
  `PASSWORD` varchar(32) NOT NULL COMMENT '用户密码',
  `IMG` varchar(50) DEFAULT NULL COMMENT '头像地址',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_CODE` (`USER_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of im_user
-- ----------------------------
INSERT INTO `im_user` VALUES ('1', 'butioy', '???', 'e35a5c01e7ed476eae86b2941acd0e8a', '96e79218965eb72c92a549dd5a330112', null, '2016-01-30 22:55:40', null);
INSERT INTO `im_user` VALUES ('2', 'butioy@163.com', '???', 'c69951adac1748ab96da50189ccbbd13', '96e79218965eb72c92a549dd5a330112', null, '2016-01-30 22:58:05', null);
INSERT INTO `im_user` VALUES ('3', 'admin', 'admin', '8235d493f76f4d8ab1d54c9b7c2d2e0c', '96e79218965eb72c92a549dd5a330112', null, '2016-01-30 23:15:46', null);

-- ----------------------------
-- Table structure for im_user_friend
-- ----------------------------
DROP TABLE IF EXISTS `im_user_friend`;
CREATE TABLE `im_user_friend` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-好友关联表ID',
  `USER_ID` int(10) NOT NULL COMMENT '用户ID',
  `USER_CODE` varchar(32) NOT NULL COMMENT '用户CODE码',
  `FRIEND_ID` int(10) NOT NULL COMMENT '好友ID',
  `FRIEND_CODE` varchar(32) NOT NULL COMMENT '好友CODE码',
  `FRIEND_GROUP_ID` int(10) NOT NULL COMMENT '所属好友分组ID',
  `FRIEND_GROUP_CODE` varchar(32) NOT NULL COMMENT '所属好友分组CODE码',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of im_user_friend
-- ----------------------------
INSERT INTO `im_user_friend` VALUES ('1', '1', '', '2', '', '1', '', '2016-01-31 10:49:37', null);
INSERT INTO `im_user_friend` VALUES ('2', '2', '', '1', '', '2', '', '2016-02-01 00:54:29', null);

-- ----------------------------
-- Table structure for im_user_group
-- ----------------------------
DROP TABLE IF EXISTS `im_user_group`;
CREATE TABLE `im_user_group` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-群组关联表ID',
  `USER_ID` int(10) NOT NULL COMMENT '用户ID',
  `USER_CODE` varchar(32) NOT NULL COMMENT '用户CODE码',
  `GROUP_ID` int(10) NOT NULL COMMENT '群组ID',
  `GROUP_CODE` varchar(32) NOT NULL COMMENT '群组CODE码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户-群组关联表';

-- ----------------------------
-- Records of im_user_group
-- ----------------------------
INSERT INTO `im_user_group` VALUES ('1', '1', '', '2', '');
INSERT INTO `im_user_group` VALUES ('2', '2', '', '2', '');
INSERT INTO `im_user_group` VALUES ('3', '1', '', '4', '');
INSERT INTO `im_user_group` VALUES ('4', '2', '', '4', '');
INSERT INTO `im_user_group` VALUES ('5', '1', '', '6', '');
INSERT INTO `im_user_group` VALUES ('6', '2', '', '6', '');
