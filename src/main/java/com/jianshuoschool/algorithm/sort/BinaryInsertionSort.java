package com.jianshuoschool.algorithm.sort;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class BinaryInsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int index = binarySearch(arr, arr[i], i - 1);
            for (int j = i - 1; j >= index; j--) {
                arr[j + 1] = arr[j];
            }
            arr[index] = tmp;
        }
    }

    private static int binarySearch(int[] arr, int target, int maxIndex) {
        int find = 0;
        while (find <= maxIndex) {
            int mid = (find + maxIndex) / 2;
            if (target > arr[mid]) {
                find = mid + 1;
            } else {
                maxIndex = mid - 1;
            }
        }
        return find;
    }

}
