package com.example;

import java.util.Scanner;

/**
 * 作用 : 住房公积金的算法
 * 作者 ：张桐源
 * 日期： 2016/11/28
 */
public class GongJiJin {

    public static void main(String[] args) {
        System.out.println("请输入你税前的工资:");

        Scanner scan = new Scanner(System.in);
        double money = scan.nextInt();
        //money*10%*2=jijin
        System.out.println("你的住房公积金是:" + money / 10 * 2 + "元");
        System.out.println("你需要缴纳:" + money / 10 + "元");
        System.out.println("公司帮你缴纳:" + money / 10 + "元");

    }
}
