package com.xwolf.eop.erp.entity;

import lombok.Data;

@Data
public class Jobs {
    private Integer jid;

    private String jcode;

    private String jname;

    private String descr;

    private Byte state;
}