
CREATE TABLE `com_menu_permission` (
  `rid` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `mcode` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单code',
  `pcode` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限(按钮)code',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
