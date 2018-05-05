package com.xiaomianshi.algorithm.sort;

import com.xiaomianshi.algorithm.Common;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Common.swap(arr, j, j + 1);
                }
            }
        }
    }

}
