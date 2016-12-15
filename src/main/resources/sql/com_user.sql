/*
Navicat MySQL Data Transfer

Source Server         : eop@localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : eop

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-12-15 18:18:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for com_user
-- ----------------------------
DROP TABLE IF EXISTS `com_user`;
CREATE TABLE `com_user` (
  `uid` int(15) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ucode` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户code',
  `uname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `nick_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `upasswd` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'qq',
  `mobile` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `ctime` datetime NOT NULL COMMENT '创建时间',
  `ccode` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人code',
  `rcode` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐人',
  `rtime` datetime DEFAULT NULL COMMENT '推荐时间',
  `ustatus` tinyint(2) NOT NULL COMMENT '用户状态',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
