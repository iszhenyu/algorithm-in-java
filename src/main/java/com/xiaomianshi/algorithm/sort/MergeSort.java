package com.xiaomianshi.algorithm.sort;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class MergeSort {

    public static void sort(int[] arr) {
        int size = arr.length;
        sub_sort(arr, 0, size - 1);
    }

    private static void sub_sort(int[] arr, int left, int right) {
        if (left < right) {
            int center = left + (right - left) / 2;
            sub_sort(arr, left, center);
            sub_sort(arr, center + 1, right);
            merge(arr, left, center, center + 1, right);
        }
    }

    private static void merge(int[] oriArr, int left1, int right1, int left2, int right2) {
        int[] assistArr = new int[oriArr.length];
        int pointer1 = left1;
        int pointer2 = left2;
        int tmp = left1;
        while (pointer1 <= right1 && pointer2 <= right2) {
            if (oriArr[pointer1] < oriArr[pointer2]) {
                assistArr[tmp] = oriArr[pointer1];
                pointer1++;
            } else {
                assistArr[tmp] = oriArr[pointer2];
                pointer2++;
            }
            tmp++;
        }
        while (pointer1 <= right1) {
            assistArr[tmp] = oriArr[pointer1];
            tmp++;
            pointer1++;
        }
        while (pointer2 <= right2) {
            assistArr[tmp] = oriArr[pointer2];
            tmp++;
            pointer2++;
        }
        tmp = left1;
        while (tmp <= right2) {
            oriArr[tmp] = assistArr[tmp];
            tmp++;
        }
    }

}
