package com.xiaomianshi.algorithm.offer;

import com.xiaomianshi.algorithm.Common;

import java.util.Arrays;

/**
 * @author zhen.yu
 * @since 2018/5/12
 */
public class PrintFullArrangement {

    /**
     * 递归实现全排列
     */
    public static void print(int[] arr) {
        subPrint(arr, 0);
    }

    private static void subPrint(int[] arr, int start) {
        if (start >= arr.length) {
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println("");
        } else {
            for (int i = start; i < arr.length; i++) {
                if (needSwap(arr, start, i)) {
                    if (i > start) {
                        Common.swap(arr, start, i);
                    }
                    subPrint(arr, start + 1);
                    // 交换回原处
                    if (i > start) {
                        Common.swap(arr, start, i);
                    }
                }
            }
        }
    }

    // 如果有重复的交换一次就好
    private static boolean needSwap(int[] arr, int start, int i) {
        for (int j = start; j < i; j++) {
            if (arr[j] == arr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字典序生成全排列
     * 1、将数组按照元素从小到大递增排序，形成字典序最小排列
     * 2、左起从A[0]开始寻找最后一个元素A[k]，满足A[k]<A[k+1](k<n−1)，n为元素个数;
     * 3、从A[k+1]向右开始寻找最小的一个A[i]，使得A[i]>A[k];
     * 4、交换A[k]与A[i]；
     * 5、对于a[k+1，n-1]，反转该区间内元素的顺序，即a[k+1]与a[n]交换，a[k+2]与a[n-1]交换，……，这样就得到了a[1…n]在字典序中的下一个排列。
     * 6、重复步骤（2）至（5），直到A按元素大小递减排序，即第二步找不到满足条件的A[k]。
     */
    public static void print2(int[] arr) {

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        print(arr);
    }

}
