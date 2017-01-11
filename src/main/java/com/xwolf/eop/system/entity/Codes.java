package com.xwolf.eop.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
@Data
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

}