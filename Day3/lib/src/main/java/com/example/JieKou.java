package com.example;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class JieKou implements JieKou1 {


    public static void main(String[] args) {
        JieKou1 j = new DiaoJieKou();
        System.out.println(j instanceof JieKou1);
        j.a();
        j.b();
        //通过关键字instanceof检测接口对象"f"是否实现了"第一个接口"，返回一个布尔//值*/


    }

    @Override
    public void a() {
        System.out.println("aaaaa");
    }

    @Override
    public void b() {
        System.out.println("bbbbb");

    }
}
