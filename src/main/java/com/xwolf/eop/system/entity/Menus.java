package com.xwolf.eop.system.entity;

public class Menus {
    private Integer mid;

    private String mcode;

    private String mname;

    private String pcode;

    private Byte isParent;

    private String murl;

    private Byte mstatus;

    private String icon;

    private Byte orderValue;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public Byte getIsParent() {
        return isParent;
    }

    public void setIsParent(Byte isParent) {
        this.isParent = isParent;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    public Byte getMstatus() {
        return mstatus;
    }

    public void setMstatus(Byte mstatus) {
        this.mstatus = mstatus;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Byte getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Byte orderValue) {
        this.orderValue = orderValue;
    }
}