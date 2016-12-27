

CREATE TABLE `com_menus` (
  `mid` int(15) NOT NULL COMMENT '主键ID',
  `mcode` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单code',
  `mname` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名称',
  `pcode` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '父菜单CODE',
  `is_parent` tinyint(2) NOT NULL COMMENT '是否是父菜单',
  `murl` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单url',
  `mstatus` tinyint(2) DEFAULT NULL COMMENT '菜单状态',
  `icon` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
