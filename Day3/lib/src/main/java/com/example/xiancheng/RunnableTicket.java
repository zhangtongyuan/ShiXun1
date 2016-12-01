package com.example.xiancheng;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class RunnableTicket {
    public static void main(String[] args) {
        TicketRunnle mt = new TicketRunnle();
        new Thread(mt).start();//同一个mt，但是在Thread中就不可以，如果用同一
        new Thread(mt).start();//个实例化对象mt，就会出现异常
        new Thread(mt).start();
    }
}

