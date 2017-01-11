package com.xwolf.eop.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private Integer uid;

    @NotEmpty
    private String ucode;

    @NotEmpty
    private String uname;

    private String nickName;
    @NotEmpty
    private transient String upasswd;

    private String email;

    private String qq;

    private String mobile;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date ctime;

    private String ccode;

    private String rcode;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date rtime;

    @NotEmpty
    private int ustatus;

}