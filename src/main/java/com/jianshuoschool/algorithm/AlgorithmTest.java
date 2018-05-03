package com.jianshuoschool.algorithm;

import com.jianshuoschool.algorithm.sort.*;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 2, 1, 9};
        testHeapSort(arr);
    }

    private static void testHeapSort(int[] arr) {
        printArr(arr);
        HeapSort.sort(arr);
        printArr(arr);
    }

    private static void testSelectSort(int[] arr) {
        printArr(arr);
        SelectSort.sort(arr);
        printArr(arr);
    }

    private static void testInsertionSort(int[] arr) {
        printArr(arr);
        InsertionSort.sort(arr);
        printArr(arr);
    }

    private static void testMergeSort(int[] arr) {
        printArr(arr);
        MergeSort.sort(arr);
        printArr(arr);
    }

    private static void testBucketSort(int[] arr) {
        printArr(arr);
        BucketSort.sort(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder("Array::[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != (arr.length - 1)) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
