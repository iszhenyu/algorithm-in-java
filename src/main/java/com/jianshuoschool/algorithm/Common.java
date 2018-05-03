package com.jianshuoschool.algorithm;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class Common {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
