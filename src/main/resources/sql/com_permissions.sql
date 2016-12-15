/*
Navicat MySQL Data Transfer

Source Server         : eop@localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : eop

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-12-15 18:41:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for com_permissions
-- ----------------------------
DROP TABLE IF EXISTS `com_permissions`;
CREATE TABLE `com_permissions` (
  `pid` int(15) NOT NULL,
  `pcode` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限code',
  `pname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限名称',
  `pvalue` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限value',
  `mcode` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单code',
  `pstatus` tinyint(2) NOT NULL COMMENT '菜单状态',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
