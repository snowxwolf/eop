
CREATE TABLE `com_user_role` (
  `rid` int(15) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ucode` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户code',
  `rcode` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色code',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
