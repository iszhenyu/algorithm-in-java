package com.xiaomianshi.algorithm.offer;

/**
 * @author zhen.yu
 * @since 2018/5/10
 *
 *
 */
public class SpinArray {

    /**
     * 输入一个递增排序的数组的旋转，输出旋转数组的最小元素
     * [4, 5, 6, 1, 2, 3] 最小的元素是1
     *
     * wrong
     */
    public static int min(int[] arr) {
        int size = arr.length;
        int lastVal = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] >= lastVal) {
                lastVal = arr[i];
                continue;
            }
            return arr[i];
        }
        return arr[0];
    }

    /**
     * wrong
     */
    public static int min2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[right]) {
                right = mid;
            } else if (arr[mid] > arr[left]) {
                left = mid;
            }
        }
        return arr[left] > arr[right] ? arr[right] : arr[left];
    }

    /**
     * wright
     */
    public static int min3(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (arr[left] >= arr[right]) {
            if (left + 1 == right) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;

            // 当三者一样时，无法判断mid是属于前面还是后面，只能顺序查找
            if (arr[left] == arr[right] && arr[right] == arr[mid]) {
                return findMinBySequence(arr, left, right);
            }

            if (arr[mid] >= arr[left]) {
                left = mid;
            } else if (arr[mid] <= arr[right]) {
                right = mid;
            }
        }
        return arr[mid];
    }

    private static int findMinBySequence(int[] arr, int left, int right) {
        int res = arr[left];
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < res) {
                res = arr[i];
            }
        }
        return res;
    }
}
