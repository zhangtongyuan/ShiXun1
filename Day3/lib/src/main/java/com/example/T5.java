package com.example;

import java.util.Scanner;

/**
 * 作用 : 求1+2!+3!+...+20!的和。
 * 作者 : 张桐源
 * 日期 ： 2016/11/30
 */
public class T5 {


    public static void main(String[] args) {
        System.out.println("1!+2!+3!+……+20!=" + getSum(20));

        int sum = 0;
        System.out.println("请输入多少项阶乘的和:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int an = 0;

        for (int i = 1; i <= n + 1; i++) {
            if (i == n + 1) {
                sum += an;
            } else if (i == n) {
                sum += an;
                an = 1;
                System.out.print(i + "!");
                for (int j = i; j >= 1; j--) {
                    an *= j;
                }
            } else if (i % 10 == 0) {
                System.out.println();
                sum += an;
                an = 1;
                System.out.print(i + "!" + "+");
                for (int j = i; j >= 1; j--) {
                    an *= j;
                }
            } else {
                sum = sum + an;
                an = 1;
                System.out.print(i + "!" + "+");
                for (int j = i; j >= 1; j--) {
                    an *= j;
                }
            }
        }
        System.out.println(" = " + sum);

    }


    public static long getSum(int n) {
        int i, k, fac, sum = 0;
        for (i = 1; i <= n; i++) {
            fac = 1;
            for (k = 1; k <= i; k++)
                fac = fac * k;
            sum = sum + fac;
        }
        return sum;
    }

}
