package com.xwolf.eop.test.rest;

import java.nio.ByteBuffer;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-12 21:17
 * @since V1.0.0
 */
public class Test {
    static {
        int x=5;
        System.out.println("s"+x);
    }
    static int x,y;

    public static void get(){
      y = x++ + ++x;
    }
    public static void main(String[] args) {
        System.out.println("计入方法..");
        x--;
        get();
        System.out.println(x+y+++x);

    }

}
