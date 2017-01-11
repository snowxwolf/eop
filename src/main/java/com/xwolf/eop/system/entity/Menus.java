package com.xwolf.eop.system.entity;

import lombok.Data;

@Data
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

}