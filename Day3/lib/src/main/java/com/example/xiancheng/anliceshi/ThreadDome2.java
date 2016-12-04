package com.example.xiancheng.anliceshi;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class ThreadDome2 {
        public static void main(String[] args){
            ThreadTest t1 = new ThreadTest();
            ThreadTest t2 = new ThreadTest();
            ThreadTest t3 = new ThreadTest();
            t1.start();
            t2.start();
            t3.start();

        }
    }
