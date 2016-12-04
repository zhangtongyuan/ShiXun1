package com.example.xiancheng.anliceshi;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class ThreadDome3 {
    public static void main(String[] args) {
        ThreadTest1 t1 = new ThreadTest1();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();

    }
}
