package com.example.xiancheng.anliceshi;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
class ThreadTest extends Thread {
    private int ticket = 100;

    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() +
                        "is saling ticket" + ticket--);
            } else {
                break;
            }
        }
    }
}