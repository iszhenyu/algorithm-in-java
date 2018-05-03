package com.jianshuoschool.algorithm.sort;

import com.jianshuoschool.algorithm.Common;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class SelectSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                Common.swap(arr, i, minIdx);
            }
        }
    }

}
