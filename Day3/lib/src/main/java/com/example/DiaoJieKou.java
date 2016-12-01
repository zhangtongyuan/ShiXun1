package com.example;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class DiaoJieKou implements JieKou1 {
    //接口的继承通过关键字implements实现
    @Override
    public void a() {
        System.out.println("接口的运用");
        final int a = 10, b = 20;
        double c;
        c = (double) (a + b);
        System.out.println(a + "+" + b + "=" + c);
    }

    @Override
    public void b() {
        System.out.println("接口的运用B");
    }
}
