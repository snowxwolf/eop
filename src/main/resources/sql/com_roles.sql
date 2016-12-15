/*
Navicat MySQL Data Transfer

Source Server         : eop@localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : eop

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-12-15 18:24:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for com_roles
-- ----------------------------
DROP TABLE IF EXISTS `com_roles`;
CREATE TABLE `com_roles` (
  `rid` int(15) NOT NULL,
  `rcode` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色code',
  `rname` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `rpcode` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色权限识别code',
  `rtime` datetime NOT NULL COMMENT '添加时间',
  `rstatus` tinyint(2) NOT NULL COMMENT '状态',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
