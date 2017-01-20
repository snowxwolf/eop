package com.xwolf.eop.erp.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Jobs {
    private Integer jid;

    private String jcode;

    @NotBlank
    @Length(max=60)
    private String jname;

    @Size(max=150)
    private String descr;

    @NotNull
    private Byte state;
}