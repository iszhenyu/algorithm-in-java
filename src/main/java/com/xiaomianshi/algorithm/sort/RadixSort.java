package com.xiaomianshi.algorithm.sort;

/**
 * @author zhen.yu
 * @since 2018/5/4
 */
public class RadixSort {

    /**
     * 基数排序
     */
    public static void lsdSort(int[] arr) {
        int size = arr.length;
        int maxVal = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        int[][] assist = new int[10][size];
        int[] assistCount = new int[10];
        int digitPos = 1;
        while (maxVal / digitPos > 0) {
            for (int i = 0; i < size; i++) {
                int cur = arr[i];
                int radix = (cur / digitPos) % 10;
                assist[radix][assistCount[radix]] = cur;
                assistCount[radix]++;
            }

            int idx = 0;
            for (int i = 0; i < 10; i++) {
                int count = assistCount[i];
                if (count > 0) {
                    for (int j = 0; j < count; j++) {
                        arr[idx] = assist[i][j];
                        idx++;
                    }
                    // assistCount 清零
                    assistCount[i] = 0;
                }
            }

            digitPos *= 10;
        }
    }

}
