package com.xwolf.eop.common.pojo.easyui;

/**
 * <p>
 *     easyui页面请求参数封装
 * </p>
 *
 * @author xwolf
 * @date 2017-01-06 18:08
 * @since V1.0.0
 */
public class PageRequest {

    private int rows=10;//每页显示记录数
    private int page=1;//当前页
    private String sort;
    private String order;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
