package com.xwolf.eop.common.pojo.easyui;

import lombok.Data;

/**
 * <p>
 *     easyui页面请求参数封装
 * </p>
 *
 * @author xwolf
 * @date 2017-01-06 18:08
 * @since V1.0.0
 */
@Data
public class PageRequest {

    private int rows=10;//每页显示记录数
    private int page=1;//当前页
    private String sort;
    private String order;
}
