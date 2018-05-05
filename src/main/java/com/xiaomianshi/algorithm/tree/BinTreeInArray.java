package com.xiaomianshi.algorithm.tree;

/**
 * @author zhen.yu
 * @since 2018/4/8
 *
 * 顺序存储的二叉树
 */
public class BinTreeInArray {
    private static final int DEFAULT_DEEP = 8;

    private Integer[] data;
    private int deep;
    private int arraySize;

    public BinTreeInArray() {
        this.deep = DEFAULT_DEEP;
        this.arraySize = (int)Math.pow(2, deep) - 1;
        this.data = new Integer[arraySize];
    }

    public BinTreeInArray(int deep) {
        this.deep = deep;
        this.arraySize = (int)Math.pow(2, deep) - 1;
        this.data = new Integer[arraySize];
    }

    public BinTreeInArray(int deep, int ele) {
        this.deep = deep;
        this.arraySize = (int)Math.pow(2, deep) - 1;
        this.data = new Integer[arraySize];
        this.data[0] = ele;
    }

    public boolean empty() {
        return this.data[0] == null;
    }

    public Integer root() {
        return this.data[0];
    }

    public Integer parent(int idx) {
        return data[(idx - 1) / 2];
    }

    public void add(Integer ele, int parentIdx, boolean left) {
        if (data[parentIdx] == null) {
            throw new RuntimeException();
        }
        int newIdx = left ? parentIdx * 2 + 1 : parentIdx * 2 + 2;
        if (newIdx >= arraySize) {
            throw new RuntimeException();
        }
        data[newIdx] = ele;
    }

    public Integer left(int idx) {
        int leftIdx = idx * 2 + 1;
        if (leftIdx >= arraySize) {
            throw new RuntimeException();
        }
        return data[leftIdx];
    }

    public Integer right(int idx) {
        int rightIdx = idx * 2 + 2;
        if (rightIdx - 1 >= arraySize) {
            throw new RuntimeException();
        }
        return data[rightIdx];
    }

}
