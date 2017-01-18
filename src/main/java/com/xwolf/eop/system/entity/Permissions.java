package com.xwolf.eop.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permissions  implements Serializable{

    private static final long serialVersionUID = 2120229469404113886L;
    private Integer pid;

    private String pcode;

    private String pname;

    private String pvalue;

    private String mcode;

    private int pstatus;

}