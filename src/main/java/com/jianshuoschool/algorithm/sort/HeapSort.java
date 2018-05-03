package com.jianshuoschool.algorithm.sort;

import com.jianshuoschool.algorithm.Common;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class HeapSort {

    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            buildMaxHeap(arr, i);
            Common.swap(arr, 0, i);
        }
    }

    private static void buildMaxHeap(int[] arr, int end) {
        if (end > 0) {
            int firstNoneLeaf = (end - 1) / 2;
            for (int j = firstNoneLeaf; j >= 0; j--) {
                maxHeapify(arr, j, end);
            }
        }
    }

    private static void maxHeapify(int[] arr, int i, int end) {
        int leftChild = (i << 1) + 1;
        int rightChild = leftChild + 1;
        int maxIdx = i;
        if (leftChild <= end && arr[leftChild] > arr[maxIdx]) {
            maxIdx = leftChild;
        }
        if (rightChild <= end && arr[rightChild] > arr[maxIdx]) {
            maxIdx = rightChild;
        }
        if (maxIdx != i) {
            Common.swap(arr, i, maxIdx);
            maxHeapify(arr, maxIdx, end);
        }
    }

}
