package com.xwolf.eop.common.pojo;

/**
 * @author wolf
 * @date 2016-12-26 23:38
 * @since V1.0.0
 */
public class PageRequest {

    private int length=10;//每页显示记录数
    private long draw;//绘制计数器。这个是用来确保Ajax从服务器返回的是对应的
    private int start;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getDraw() {
        return draw;
    }

    public void setDraw(long draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
