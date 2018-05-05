package com.xiaomianshi.algorithm;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class Common {

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
