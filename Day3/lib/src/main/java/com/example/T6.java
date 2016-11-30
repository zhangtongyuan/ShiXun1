package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用：5位数中找出所有，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同
 * 作者:张桐源
 * 日期： 2016/11/30
 */
public class T6 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("输入要判断是否为回文数的数值：");
        int i = sc.nextInt();
        String str = "" + i;
        if (str.length() % 2 == 0) {
            System.out.println(i + "不是回文数!" + str.length() % 2);
        }
        //判断反转后 值是否相等 从而
        else if (i == fanzhuan(i)) {
            System.out.println(i + "是回文数~");
        } else
            System.out.println(i + "不是回文数!");
        */
        List<Integer> list = new ArrayList<>();
        for (int a = 10000; a < 100000; a++) {
            String text = "" + a;
         /*   if (text.length() % 2 == 0) {
                //System.out.println(a + "不是回文数!" + text.length() % 2);
            }*/
            //判断反转后 值是否相等 从而
            if (a == fanzhuan(a)) {
                list.add(a);
                //System.out.println(a + "是回文数~");
            } else {
                //System.out.println(a + "不是回文数!");
            }
        }
        System.out.println("以下是5位数的回文数:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "   ");
            if (i % 21 == 0) {
                System.out.println("");
            }
        }
    }

    private static int fanzhuan(int input) {
        int output = 0;//
        while (input > 0) {
            //output= output*10;
            output = output * 10 + input % 10;
            input = input / 10;
        }
        return output;
    }
}
