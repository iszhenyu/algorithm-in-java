package com.xiaomianshi.algorithm.offer;

import com.xiaomianshi.algorithm.Common;

/**
 * @author zhen.yu
 * @since 2018/5/11
 *
 * 输入一个整数数组，将数组中所有计数排在数组的前面，偶数排在后面
 */
public class SortIntArray {

    public static void reSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            while (left <= right && (arr[left] & 1) > 0) {
                left++;
            }
            while (left <= right && (arr[right] & 1) == 0) {
                right--;
            }
            if (left < right) {
                Common.swap(arr, left, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 6, 7, 8, 9};
        reSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}
