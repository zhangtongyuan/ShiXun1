package com.example;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 作用 : 遍历出一个文件夹下的所有文件，并展示出层级关系，文件夹优先显示，最后以一定格式写入文本中
 * 要求：尽可能简单、逻辑清晰
 * 所选存储格式结构也能看出层级关系，并可读写后直接使用
 * 作者 : 张桐源
 * 日期 ： 2016/11/30
 */
public class T1 {
    public static void main(String[] args) throws Exception {
        //递归显示   file 所有文件夹及其中文件
        File file = new File("D:/CeShi");
        list(file, 0);
    }


    public static String getSpace(int level) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < level; i++)
            sb.append("  ");
        return sb.toString();
    }

    public static void list(File dir, int level) {
        File[] list = dir.listFiles();
        System.out.println(getSpace(level) + dir);
        level++;
        if (list != null) {
            for (File f : list) {
                if (f.isDirectory())
                    list(f, level);
                else
                    System.out.println(getSpace(level) + f);
            }
        }
    }

    public static void list(File file) {
        File files[] = file.listFiles(new FilenameFilter() {//定义一个内部类实现接口FilenameFilter，而不用再实现一个新的类去实现接口

            public boolean accept(File f, String name) {
                File tempfile = new File(f, name);
                if (tempfile.isDirectory())
                    return true;
                return name.endsWith(".txt");

            }
        });
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory())
                    list(f);
                else
                    System.out.println(f.getAbsolutePath());
            }
        }
    }

}


