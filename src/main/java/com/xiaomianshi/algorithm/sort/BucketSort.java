package com.xiaomianshi.algorithm.sort;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class BucketSort {

    public static void sort(int[] input, int[] output, int bucketSize) {
        Node[] bucket = new Node[bucketSize];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new Node(); // 头结点
        }
        for (int i = 0; i < input.length; i++) {
            int bucketIndex = hash(input[i]);
            Node node = new Node(input[i]);
            Node p = bucket[bucketIndex];
            if (p.next == null) { // 没有元素
                p.next = node;
            } else { // 已经有一个元素
                while (p.next != null && p.next.data <= node.data) {
                    p = p.next;
                } // 跳出循环时候 该值小于下一个元
                node.next = p.next;
                p.next = node;
            }
        }
        int j = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (Node p = bucket[i].next; p != null; p = p.next) {  // n/m
                output[j++] = p.data;
            }
        }
    }

    private static int hash(int value) {
        return value / 10;
    }

    private static class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }
}
