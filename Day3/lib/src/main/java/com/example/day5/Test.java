package com.example.day5;

/**
 * 作用
 * 作者
 * 日期： 2016/12/2
 */
public class Test {
    public static void main(String[] args) {
        User u = new User("张三", 100);
        //  new MyThread(u).
        MyThread m = new MyThread("线程A", u, 20);
        new Thread(m).start();
        new Thread(m).start();
        new Thread(m).start();
        new Thread(m).start();

/*        MyThread t1 = new MyThread("线程A", u, 20);
        MyThread t2 = new MyThread("线程B", u, -60);
        MyThread t3 = new MyThread("线程C", u, -80);
        MyThread t4 = new MyThread("线程D", u, -30);
        MyThread t5 = new MyThread("线程E", u, 32);
        MyThread t6 = new MyThread("线程F", u, 21);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();*/
    }
}
