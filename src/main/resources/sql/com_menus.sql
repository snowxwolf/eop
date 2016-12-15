/*
Navicat MySQL Data Transfer

Source Server         : eop@localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : eop

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-12-15 18:30:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for com_menus
-- ----------------------------
DROP TABLE IF EXISTS `com_menus`;
CREATE TABLE `com_menus` (
  `mid` int(15) NOT NULL COMMENT '主键ID',
  `mcode` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单code',
  `mname` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名称',
  `pcode` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '父菜单CODE',
  `is_parent` tinyint(2) NOT NULL COMMENT '是否是父菜单',
  `murl` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单url',
  `mstatus` tinyint(2) DEFAULT NULL COMMENT '菜单状态',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
