package com.example.xiancheng;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class MyThread implements Runnable {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程开始：" + this.name + ",i=" + i);
        }
    }

}
