package com.example;

/**
 * 作用 :二分法寻找下标
 * 作者 ：张桐源
 * 日期： 2016/11/28
 */
public class ErFenFa {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 23, 34, 45, 56, 67, 77, 89, 90};
        System.out.println(search(arr, 12));
        System.out.println(search(arr, 45));
        System.out.println(search(arr, 67));
        System.out.println(search(arr, 89));
        System.out.println(search(arr, 99));
    }

    public static int search(int[] arr, int key) {
        int start = 0;
        //中间
        int end = arr.length - 1;
        //循环条件0<集合的长度-1
        while (start <= end) {
            int middle = (start + end) / 2;
            if (key < arr[middle]) {
                end = middle - 1;
            } else if (key > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
