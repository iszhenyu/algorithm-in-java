package com.jianshuoschool.algorithm.sort;

import com.jianshuoschool.algorithm.Common;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class QuickSort {

    public static void sort(int[] arr) {
        int size = arr.length;
        subSort(arr, 0, size - 1);
    }

    private static void subSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start + 1;
        int right = end;
        int pivot = arr[start];
        while (left <= right) {
            while (left <= end && arr[left] <= pivot) {
                left++;
            }
            while (right >= start + 1 && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                Common.swap(arr, left, right);
            }
        }
        Common.swap(arr, start, right);
        subSort(arr, start, right - 1);
        subSort(arr, right + 1, end);
    }

}
