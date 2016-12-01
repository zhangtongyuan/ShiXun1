package com.example.xiancheng;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class Ticket extends Thread {
    private int ticket=10;
    public void run(){
        for(int i=0;i<20;i++){
            if(this.ticket>0){
                System.out.println("卖票：ticket"+this.ticket--);
            }
        }
    }
}
