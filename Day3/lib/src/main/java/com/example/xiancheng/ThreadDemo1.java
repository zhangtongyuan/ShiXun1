package com.example.xiancheng;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread a = new MyThread("线程a");
        MyThread b = new MyThread("线程b");
        new Thread(a).start();
        new Thread(b).start();
    }

}
