package com.example.day5;

/**
 * 作用
 * 作者
 * 日期： 2016/12/2
 */
public class MyThread implements Runnable {
    private User u;
    private int y = 0;

    MyThread(String name, User u, int y) {

        this.u = u;
        this.y = y;
    }



    public void run() {
        u.oper(y);
    }
}
