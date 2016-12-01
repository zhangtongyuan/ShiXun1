package com.example;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class BianLi {
    //创建类
    public static void main(String[] args) {
        int arr[][] = new int[][] { { 1 }, { 1, 2 }, { 1, 2, 3 } };
        for (int i = 0; i < arr.length; i++) {
            int[] arr2 = arr[i];
            for (int c = 0; c < arr2.length; c++) {
                System.out.print(arr2[c]);
            }

            System.out.println();

        }

    }
}
