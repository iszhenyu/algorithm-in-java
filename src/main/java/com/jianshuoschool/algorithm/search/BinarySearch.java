package com.jianshuoschool.algorithm.search;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class BinarySearch {

    public static int search(int[] sortedArr, int item) {
        int start = 0;
        int end = sortedArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (sortedArr[mid] == item) {
                return mid;
            }
            if (sortedArr[mid] > item) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
