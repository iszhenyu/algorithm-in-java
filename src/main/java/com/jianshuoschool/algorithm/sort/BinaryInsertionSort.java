package com.jianshuoschool.algorithm.sort;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class BinaryInsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int low = 0;
            int high = i - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (tmp > arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            for (int j = i; j > low; j--) {
                arr[j] = arr[j - 1];
            }
            arr[low] = tmp;
        }
    }

}
