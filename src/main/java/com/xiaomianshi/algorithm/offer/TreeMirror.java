package com.xiaomianshi.algorithm.offer;

import com.xiaomianshi.algorithm.tree.TreeNode;

/**
 * @author zhen.yu
 * @since 2018/5/11
 *
 * 给定一棵树，输出它的镜像
 *
 */
public class TreeMirror {

    /**
     * 递归
     */
    public static void mirror1(TreeNode root) {
        if (root == null || (root.leftChild == null && root.rightChild == null)) {
            return;
        }
        TreeNode tmp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = tmp;
        if (root.leftChild != null) {
            mirror1(root.leftChild);
        }
        if (root.rightChild != null) {
            mirror1(root.rightChild);
        }
    }

    /**
     * 后续遍历的翻转是 镜像的先序遍历
     *
     * 1 生成后续遍历的数组
     * 2 翻转数组
     * 3 按数组生成tree
     */
    public static TreeNode mirror(TreeNode root) {
        return null;
    }
}
