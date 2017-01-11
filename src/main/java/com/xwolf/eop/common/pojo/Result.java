package com.xwolf.eop.common.pojo;

import lombok.Data;

/**
 * 返回结果实体
 * @author xwolf
 * @date 2016-12-15 14:50
 * @since V1.0.0
 */
@Data
public class Result {

    private boolean success;
    private String restMsg;
    private String restCode;
    private String data;

}
