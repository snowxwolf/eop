package com.xwolf.eop.erp.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
 @Data
public class Employees {
    private Integer eid;

    private String ecode;

    private String dcode;

    private String jcode;

    private String eno;

    private String ename;

    private String ecardno;

    private Date birth;

    private String mobile;

    private String email;

    private String blog;

    private String qq;

    private String weixin;

    private String otherSocial;

    @JSONField(format = "yyyy-MM-dd")
    private Date inDate;
     @JSONField(format = "yyyy-MM-dd")
    private Date leaveDate;

    private String dealInCode;

    private String dealLeaveCode;

    private Byte state;

}