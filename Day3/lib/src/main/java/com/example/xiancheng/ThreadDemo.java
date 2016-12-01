package com.example.xiancheng;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread a = new MyThread("线程A");
        MyThread b = new MyThread("线程B");
        a.run();
        b.run();
        /*a.start();
        b.start();*/
    }
}
