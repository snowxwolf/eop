package com.xwolf.eop.test.core;

import com.xwolf.eop.util.MD5;

import java.util.Scanner;

/**
 * @author xwolf
 * @date 2016-12-14 10:21
 * @since V1.0.0
 */
public class Input {

    public static void in(){
        System.out.println("========================");
        System.out.println("\t\t主菜单");
        System.out.println("\t\t1.注册");
        System.out.println("\t\t2.登录");
        System.out.println("\t\t3.帮助信息");
        System.out.println("请选择");
        System.out.println("========================");
        //读取控制台输入的数据
        Scanner scanner=new Scanner(System.in);
        String a=scanner.next();
        switch (a){
            case "1":
                System.out.println("点击了注册...");
                break;
            case "2":
                System.out.println("点击了登录...");
                break;
            case "3":
                System.out.println("点击了帮助信息...");
                break;
            default:
                System.out.println("您输入的数字没有合适的选项.");
                break;
        }

    }
    public static void main(String[] args) {
          //in();
        System.out.println(MD5.getMessageDigest("admin","UTF-8"));
    }
}
