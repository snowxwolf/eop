

CREATE TABLE `com_role_menu` (
  `rid` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `rcode` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色code',
  `mcode` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单code',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
