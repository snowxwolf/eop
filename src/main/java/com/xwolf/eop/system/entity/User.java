package com.xwolf.eop.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -5720544131598286487L;
    private Integer uid;

    private String ucode;

    @NotEmpty
    private String uname;

    private String nickName;

    private transient String upasswd;

    private String email;

    private String qq;

    private String mobile;

    @JSONField(format = "yyyy-MM-dd")
    private Date ctime;

    private String ccode;

    private String rcode;
    @JSONField(format = "yyyy-MM-dd")
    private Date rtime;

    private int ustatus;

}