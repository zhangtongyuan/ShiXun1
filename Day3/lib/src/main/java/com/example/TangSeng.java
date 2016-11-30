package com.example;

/**
 * 作用 : 继承
 * 作者 : 张桐源
 * 日期 ： 2016/11/30
 */

public class TangSeng extends PerSon {
    private String jineng;

    public String jineng() {
        return jineng;
    }

    public void jineng(String jineng) {
        this.jineng = jineng;

    }

    public TangSeng(String jineng) {
        super();
        this.jineng = jineng;
    }

    public TangSeng() {
        super();
        jineng = "吹";
    }

    public TangSeng(String name, int age) {
        super(name, age);
        jineng = "会飞";
    }


    @Override
    public String toString() {
        return "TangSeng{" +
                "技能='" + jineng + '\'' + "姓名:='" + getName() + '\'' + "年龄='" + getAge() + '\'' +
                '}';
    }
}
