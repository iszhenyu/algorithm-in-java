package com.xiaomianshi.algorithm.sort;

import com.xiaomianshi.algorithm.Common;

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

        // 当start + 1 == end时，也要进while一次，否则下面直接swap会出错，所以这里必须是<=
        while (left <= right) {
            // 从左侧开始找到第一个大于pivot的值，结果是要么找到，要么越界
            while (left <= end && arr[left] <= pivot) {
                left++;
            }
            // 从右侧开始找到第一个小于pivot的值，结果是要么找到，要么越界
            while (right >= start + 1 && arr[right] >= pivot) {
                right--;
            }

            // 这里left不可能等于right，如果left==right则意味着一个数既大于pivot又小于pivot，显然是矛盾的
            if (left < right) {
                Common.swap(arr, left, right);
            }
        }

        // 当right停在比pivot小的元素时，直接交换
        // 如果right越界，则right == start
        Common.swap(arr, start, right);
        subSort(arr, start, right - 1);
        subSort(arr, right + 1, end);
    }

}
