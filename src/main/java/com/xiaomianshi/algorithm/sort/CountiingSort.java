package com.xiaomianshi.algorithm.sort;

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
        // 创建0-k的数组，并初始化为0
        int[] base = new int[k + 1];
        // 对于input中的每个元素，如果值i出现一次，则相应的base[i]加1
        // 最终base数组中每个位置的数值大小代表了取该值的元素数量
        for (int i = 0; i < input.length; i++) {
            base[input[i]] += 1;
        }
        // 因为base是已经排序好了的，所以从索引0开始，将当前索引处的值加到下一个索引的值上
        // 最后base数组每个元素的值大小，代表了有多少个元素小于等于当前索引的大小
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
