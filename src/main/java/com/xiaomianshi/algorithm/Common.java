package com.xiaomianshi.algorithm;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class Common {

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static class LinkNode {
        public int data;
        public LinkNode next;
        public LinkNode pre;

        public LinkNode() {
        }

        public LinkNode(int data) {
            this.data = data;
        }
    }

}
