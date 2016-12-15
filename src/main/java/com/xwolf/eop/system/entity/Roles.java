package com.xwolf.eop.system.entity;

import java.util.Date;

public class Roles {
    private Integer rid;

    private String rcode;

    private String rname;

    private String rpcode;

    private Date rtime;

    private int rstatus;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRpcode() {
        return rpcode;
    }

    public void setRpcode(String rpcode) {
        this.rpcode = rpcode;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public int getRstatus() {
        return rstatus;
    }

    public void setRstatus(int rstatus) {
        this.rstatus = rstatus;
    }
}