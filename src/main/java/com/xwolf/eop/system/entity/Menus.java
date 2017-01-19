package com.xwolf.eop.system.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class Menus {
    private Integer mid;

    private String mcode;
    @NotBlank
    private String mname;

    private String pcode;

    private Byte parent;

    private String murl;

    private Byte mstatus;

    private String icon;

    private Byte orderValue;

}