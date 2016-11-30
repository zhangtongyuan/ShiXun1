package com.example;

/**
 * 作用
 * 作者
 * 日期： 2016/11/30
 */
public class T3 {
    public static void main(String[] args) {
        //a表示一月份 b表示 2月份  c表示多少对兔子

        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 1; i <= 12; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.println("******第 " + i + " 月份有 " + c + " 对兔子****");

        }
    }
}
