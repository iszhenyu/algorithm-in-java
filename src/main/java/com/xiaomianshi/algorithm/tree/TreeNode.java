package com.xiaomianshi.algorithm.tree;

/**
 * @author zhen.yu
 * @since 2018/5/4
 */
public class TreeNode {
    Integer data;
    double weight;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(Integer data, double weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int left = leftChild == null ? 0 : leftChild.data;
        int right = rightChild == null ? 0 : rightChild.data;
        return data + left + right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
