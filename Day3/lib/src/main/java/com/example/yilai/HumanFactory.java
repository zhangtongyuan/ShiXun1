package com.example.yilai;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class HumanFactory {
    public Human getHuman(String type) {
        if ("chinese".equals(type)) {
            return new Chinese();
        } else {
            return new American();
        }
    }
}
