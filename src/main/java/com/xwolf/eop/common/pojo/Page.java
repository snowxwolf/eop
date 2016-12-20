package com.xwolf.eop.common.pojo;

/**
 * @author xwolf
 * @date 2016-12-17 07:59
 * @since V1.0.0
 */
public class Page {

    private int page=1;
    private int size=10;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
