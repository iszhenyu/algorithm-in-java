package com.xiaomianshi.algorithm;

import com.xiaomianshi.algorithm.tree.TreeNode;

/**
 * @author zhen.yu
 * @since 2018/5/10
 */
public class RebuildBinTree {

    static int[] PRE_ORDER = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
    static int[] IN_ORDER = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

    public static TreeNode rebuild(int[] preOrder, int[] inOrder) {
        TreeNode root = new TreeNode();
        recursiveBuild(root, true,
                preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
        return root.leftChild;
    }

    private static void recursiveBuild(TreeNode parent, boolean isLeft,
                                       int[] preOrder, int preStart, int preEnd,
                                       int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return;
        }

        TreeNode curRoot = new TreeNode(preOrder[preStart]);
        if (isLeft) {
            parent.leftChild = curRoot;
        } else {
            parent.rightChild = curRoot;
        }
        int splitIdx = indexOf(inOrder, preOrder[preStart]);
        int leftNum = splitIdx - inStart;

        // 构建左子树
        recursiveBuild(curRoot, true,
                preOrder, preStart + 1, preStart + leftNum,
                inOrder, inStart, splitIdx - 1);
        // 构建右子树
        recursiveBuild(curRoot, false,
                preOrder, preStart + leftNum + 1, preEnd,
                inOrder, splitIdx + 1, inEnd);
    }

    private static int indexOf(int[] arr, int val) {
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                res = i;
                break;
            }
        }
        return res;
    }
}
