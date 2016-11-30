package com.example;
/**
 * 作用 : 多态多种形式表现
 * 作者 : 张桐源
 * 日期 ： 2016/11/30
 */
public class ExtendsClass {
    public static void main(String args[]) {

        PerSon person = new PerSon();
        person.setName("张三");
        person.setAge(22);
        System.out.println(person);

        TangSeng s=new TangSeng();
        System.out.println(s);
        //继承
        TangSeng ts = new TangSeng();

        ts.setName("张三");
        ts.setAge(30);

        System.out.println(ts.getName() + ts.getAge());


        ts = new TangSeng("吹牛b");
        System.out.println(ts);


        TangSeng t1=new TangSeng("沙僧",111);
        System.out.println(t1);
    }
}
