package com.xwolf.eop.system.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Citys implements Serializable{

    private static final long serialVersionUID = 7072513495209422317L;
    private Integer cid;

    private String bcode;

    private String ccode;

    private String cname;

    private String pcode;

    private Date ctime;

    private int cstatus;

}