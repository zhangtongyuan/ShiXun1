package com.example;

import java.io.File;

/**
 * 作用 : 递归遍历文件夹和文件
 * 作者 ：张桐源
 * 日期： 2016/11/28
 */
public class DiGui {
    public static void main(String[] args) throws Exception {
        //递归显示   file 所有文件夹及其中文件
        File root = new File("D:/GiteHub");
        showAllFiles(root);
    }

    final static void showAllFiles(File dir) throws Exception {
        File[] fs = dir.listFiles();
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fs[i].getAbsolutePath());
            if (fs[i].isDirectory()) {
                try {
                    showAllFiles(fs[i]);
                } catch (Exception e) {
                }
            }
        }
    }
}
