package com.xwolf.eop.common.pojo.datatables;

import lombok.Data;

/**
 * @author wolf
 * @date 2016-12-26 23:38
 * @since V1.0.0
 */
@Data
public class PageRequest {

    private int length=10;//每页显示记录数
    private long draw;//绘制计数器。这个是用来确保Ajax从服务器返回的是对应的
    private int start;
}
