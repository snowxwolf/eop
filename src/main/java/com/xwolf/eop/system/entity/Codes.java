package com.xwolf.eop.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@Data
public class Codes implements Serializable{
    private Integer cid;

    @NotBlank(message = "code 不能为空")
    @Length(min=1,max=60)
    private String code;

    @NotBlank
    @Length(min=1,max=200)
    private String cvalue;

    @NotBlank
    @Length(min=1,max = 60)
    private String cname;

    @JSONField(format = "yyyy-MM-dd")
    private Date ctime;

    @NotNull(message = "排序值不能为空")
    private int corder;

    @NotBlank
    @Length(min=0,max=60)
    private String descr;

    @NotNull
    private int cstatus;

}