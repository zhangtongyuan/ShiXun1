package com.example;

/**
 * 作用
 * 作者
 * 日期： 2016/12/1
 */
public class MaoPao {
    public static void main(String[] args) {
        int arr[] = {5, 6, 12, 63, 99, 25, 244, 1};
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
