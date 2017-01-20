package com.xwolf.eop.erp.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
 @Data
public class Departments {
    private Integer did;

    private String code;

    private String dname;

    private Integer parent;

    private String pcode;

    private String createCode;

     @JSONField(format = "yyyy-MM-dd")
    private Date createTime;

     @JSONField(format = "yyyy-MM-dd")
    private Date updateTime;

    private String updateCode;

    private String descr;

    private Byte state;


}