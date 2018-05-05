package com.xiaomianshi.algorithm.sort;

/**
 * @author zhen.yu
 * @since 2018/5/4
 */
public class ShellSort {

    /**
     * 希尔排序
     */
    public static void sort(int[] a) {
        int n = a.length;
        int h  = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int group = 0; group < h; group++) {
                subSort(a, group, h);
            }
            h = (h - 1) / 3;
        }
    }

    private static void subSort(int[] a, int start, int gap) {
        for (int i = start + gap; i < a.length; i += gap) {
            int item = a[i];
            int j = i;
            while (j > start && item < a[j - gap]) {
                a[j] = a[j - gap];
                j -= gap;
            }
            a[j] = item;
        }
    }

}
