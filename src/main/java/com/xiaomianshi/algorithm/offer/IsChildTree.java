package com.xiaomianshi.algorithm.offer;

import com.xiaomianshi.algorithm.tree.TreeNode;

/**
 * @author zhen.yu
 * @since 2018/5/11
 *
 * 给定两棵二叉树a，b，判断b是不是a的子结构
 */
public class IsChildTree {

    public static boolean isChild(TreeNode a, TreeNode b) {
        boolean res = false;
        if (a != null && b != null) {
            if (a.data == (int) b.data) {
                res = has(a, b);
            }
            if (!res) {
                res = isChild(a.leftChild, b);
            }
            if (!res) {
                res = isChild(a.rightChild, b);
            }
        }
        return res;
    }

    private static boolean has(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.data != (int) b.data) {
            return false;
        }
        return has(a.leftChild, b.leftChild) && has(a.rightChild, b.rightChild);
    }

    public static void main(String[] args) {

    }

}
