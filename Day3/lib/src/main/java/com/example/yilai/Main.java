package com.example.yilai;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class Main {
    public static void main(String[] args) {
        /******** 工厂方法， Main类与类Chinese和American不再耦合，仅仅和其接口Human耦合 ***********/
        // 修改时还需要修改在Main类中修改这些字符串
        // Chinese和American，当类和方法修改时，只有方法需要修改
        HumanFactory humanFactory = new HumanFactory();
        Human human1 = humanFactory.getHuman("chinese");
        human1.sayHelloWorld("王二");

        Human human2 = humanFactory.getHuman("american");
        human2.sayHelloWorld("json");
    }
}
