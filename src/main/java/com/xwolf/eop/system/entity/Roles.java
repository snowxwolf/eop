package com.xwolf.eop.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@Data
public class Roles implements Serializable {
    private Integer rid;

    private String rcode;
    @NotBlank
    @Length(max=20)
    private String rname;

    @NotBlank
    private String rpcode;

    @JSONField(format = "yyyy-MM-dd")
    private Date rtime;
    @NotNull
    private int rstatus;

}