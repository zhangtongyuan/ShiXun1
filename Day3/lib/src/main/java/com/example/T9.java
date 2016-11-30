package com.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 作用: 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位
 * 作者: 张桐源
 * 日期: 2016/11/30
 */
public class T9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入总人数：");
        int p = input.nextInt();
        /****
         * 初始化人员
         ***/
        boolean[] per = new boolean[p];// boolean数组表示站成一圈的人，false表示退出
        for (int i = 0; i < per.length; i++) {
            per[i] = true;
        }

        /****
         * 报号
         ***/
        int t = 0, len = per.length;

        while (len > 1)

        {
            for (int i = 0; i < per.length; i++) {

                if (per[i]) {
                    t++;
                    if (t == 3) {
                        t = 0;
                        per[i] = false;
                        len--;

                    }
                }
            }
        }
        /***** 结果 *****/

        System.out.println("最后的情况：" + Arrays.toString(per));
        for (int i = 0; i < per.length; i++)

        {
            if (per[i]) {
                System.out.println("原来喊的数：" + (i + 1));
            }
        }
    }

}
