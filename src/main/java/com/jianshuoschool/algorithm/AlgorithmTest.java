package com.jianshuoschool.algorithm;

import com.jianshuoschool.algorithm.sort.*;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 2, 3, 1, 9};
        testSort(arr);
//        testCountingSort(arr);
    }

    private static void testSort(int[] arr) {
        printArr(arr);
        ShellSort.sort(arr);
        printArr(arr);
    }

    private static void testCountingSort(int[] arr) {
        int[] result = new int[arr.length];
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        printArr(arr);
        CountiingSort.sort(arr, result, maxVal);
        printArr(result);
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
