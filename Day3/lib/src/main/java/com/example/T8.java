package com.example;

/**
 * 作用: 计算字符串中子串出现的次数
 * 作者: 张桐源
 * 日期: 2016/11/30
 */
public class T8 {
    public static void main(String[] args) {
        String str = "abcdefababhjlecababcab";
        String str1 = "ab";
        int count = 0;
        int start = 0;
        while (str.indexOf(str1, start) >= 0 && start < str.length()) {
            count++;
            start = str.indexOf(str1, start) + str1.length();
        }
        System.out.println(str1 + "在" + str + "出现的次数为" + count);
    }
}
