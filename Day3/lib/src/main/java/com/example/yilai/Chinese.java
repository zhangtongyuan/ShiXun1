package com.example.yilai;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class Chinese implements  Human{

    @Override
    public void sayHelloWorld(String name) {
            String helloWorld = "你好，" + name;
            System.out.println(helloWorld);
    }
}
