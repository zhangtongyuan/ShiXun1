package com.example;

/**
 * 作用 : 封装
 * 作者 : 张桐源
 * 日期 ： 2016/11/30
 */
public class PerSon {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PerSon() {
        super();
        name = "唐僧";
        age = 118;
    }

    public PerSon(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PerSon [name=" + name + ", age=" + age + "]";
    }
}
