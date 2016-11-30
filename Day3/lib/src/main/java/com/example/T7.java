package com.example;

/**
 * 作用: 打印出杨辉三角形（要求打印出10行以上）
 * 作者: 张桐源
 * 日期: 2016/11/30
 */
public class T7 {
    public static void main(String[] args) {
        int[][] a = new int[10][10];
        for (int i = 0; i < 10; i++) {
            a[i][i] = 1;
            a[i][0] = 1;
        }
        //此处for循环给中心值赋值
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < i; j++) {
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
            }
        }
        //此处for循环给将三角形以外空格显示出来
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 2 * (10 - i) - 1; k++) {
                System.out.print("  ");
            }
            //此处for循环给将杨辉三角形内部数字以及空格显示出来。
            for (int j = 0; j <= i; j++) {
                System.out.print(a[i][j] + "      ");
            }
            System.out.println();
        }
    }
}
