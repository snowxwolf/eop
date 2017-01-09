package com.xwolf.eop.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

public class Codes implements Serializable{
    private Integer cid;

    @NotBlank
    private String code;
    @NotBlank
    private String cvalue;

    @NotBlank
    private String cname;

    @JSONField(format = "yyyy-MM-dd")
    private Date ctime;

    @NotBlank
    private int corder;

    @NotBlank
    private int cstatus;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCvalue() {
        return cvalue;
    }

    public void setCvalue(String cvalue) {
        this.cvalue = cvalue;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public int getCorder() {
        return corder;
    }

    public void setCorder(int corder) {
        this.corder = corder;
    }

    public int getCstatus() {
        return cstatus;
    }

    public void setCstatus(int cstatus) {
        this.cstatus = cstatus;
    }
}