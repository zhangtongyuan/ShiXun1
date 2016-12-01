package com.example.xiancheng;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class ThreadTicket {
    public static void main(String[] args) {
        Ticket mt1 = new Ticket();
        Ticket mt2 = new Ticket();
        Ticket mt3 = new Ticket();
        mt1.start();//每个线程都各卖了10张，共卖了30张票
        mt2.start();//但实际只有10张票，每个线程都卖自己的票
        mt3.start();//没有达到资源共享
    }
}
