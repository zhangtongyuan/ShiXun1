package com.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 作用 : IO流实现文件的复制
 * 作者 ：张桐源
 * 日期： 2016/11/28
 */
public class FileCopy {
    //复制字符流/txt文本格式
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("D:/GiteHub/xiangmudemo.txt")));
        //复制到指定的位置
        PrintWriter pw = new PrintWriter("D:/GiteHub/复制的文件/xiangmudemo.txt");
        String s = null;
        while ((s = br.readLine()) != null) {
            pw.write(s);
        }
        pw.close();
    }
}
