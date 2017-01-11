package com.xwolf.eop.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Roles implements Serializable {
    private Integer rid;

    private String rcode;

    private String rname;

    private String rpcode;

    @JSONField(format = "yyyy-MM-dd")
    private Date rtime;

    private int rstatus;

}