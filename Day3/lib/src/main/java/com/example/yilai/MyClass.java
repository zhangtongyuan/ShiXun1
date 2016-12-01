package com.example.yilai;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class MyClass {
    public static void main(String[] args) {
        /******** 一般写法，Main类与Chinese类和American类之间的强耦合 ***********/
        // Chinese和American，当类和方法修改时，此处的类和方法也需要修改
        Chinese chinese = new Chinese();
        chinese.sayHelloWorld("张三");

        American american = new American();
        american.sayHelloWorld("Jack");
    }
}
