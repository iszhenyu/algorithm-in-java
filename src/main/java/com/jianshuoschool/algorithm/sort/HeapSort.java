package com.jianshuoschool.algorithm.sort;

import com.jianshuoschool.algorithm.Common;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class HeapSort {

    public static void sort(int[] arr) {

    }

    private static void maxHeapify(int[] arr, int i) {
        int leftChild = i << 1;
        int rightChild = leftChild + 1;
        int maxIdx = i;
        if (leftChild < arr.length && arr[leftChild] > arr[maxIdx]) {
            maxIdx = leftChild;
        }
        if (rightChild < arr.length && arr[rightChild] > arr[maxIdx]) {
            maxIdx = rightChild;
        }
        if (maxIdx != i) {
            Common.swap(arr, i, maxIdx);
            maxHeapify(arr, maxIdx);
        }
    }

}
