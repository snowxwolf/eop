package com.xwolf.eop.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * 黑名单
 */
@Data
public class BlackList {

    private Integer id;
    private String ip;
    private String mac;

    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;

    private Integer status;


}