

/*基础码表*/
CREATE TABLE `com_codes` (
  `cid` int(15) NOT NULL,
  `code` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '码表code',
  `cvalue` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '码表值',
  `cname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '码表对应名称',
  `ctime` datetime NOT NULL COMMENT '创建时间',
  `corder` tinyint(2) NOT NULL COMMENT '排序值',
  `cstatus` tinyint(2) NOT NULL COMMENT '码表状态',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
