package com.jianshuoschool.algorithm.sort;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class CountiingSort {

    /**
     * 计数排序
     * @param input 输入待排序数组
     * @param output 排序后的输出数组
     * @param k 输入数组的每个元素在[0, k]之间
     */
    public static void sort(int[] input, int[] output, int k) {
        int[] base = new int[k + 1];
        for (int i = 0; i < input.length; i++) {
            base[input[i]] += 1;
        }
        for (int i = 1; i <= k; i++) {
            base[i] += base[i - 1];
        }
        for (int i = 0; i < input.length; i++) {
            int index = base[input[i]];
            output[index - 1] = input[i];
            base[input[i]] -= 1;
        }
    }

}
