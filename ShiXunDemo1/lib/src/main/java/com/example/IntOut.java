package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 * 作用 : 复习java知识
 * 作者 : 张桐源
 * 日期： 2016/11/28
 */
public class IntOut {
    public static void main(String[] args) {
        File file = new File("D:/GiteHub/xiangmudemo.txt");
        try {

            // 向文件写入内容(输出流)
            String str = "这是一行字";
            byte bt[] = new byte[1024];
            bt = str.getBytes();
            FileOutputStream out = new FileOutputStream(file, true);
            out.write(bt, 0, bt.length);
            out.close();

            // 读取文件内容 (输入流)
            FileInputStream in = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(in);

            int i = 0;
            while ((i = isr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
