package com.xiaomianshi.algorithm.offer;

import com.xiaomianshi.algorithm.tree.BinTreeInLink;
import com.xiaomianshi.algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhen.yu
 * @since 2018/5/12
 *
 * 在垂直路径中找到之和为指定值的路径
 */
public class FindPathInBinTree {

    public static void print(TreeNode root, int sum) {
        findPath(root, sum);
    }


    private static boolean findPath(TreeNode root, int rest) {
        if (root.data > rest) {
            return false;
        }

        boolean isLeaf = root.leftChild == null && root.rightChild == null;
        if (isLeaf && rest == root.data) {
            System.out.println(root.data);
            return true;
        }
        if (isLeaf) {
            return false;
        }

        int restRest = rest - root.data;

        boolean isLeftMatch = false;
        if (root.leftChild != null) {
            isLeftMatch = findPath(root.leftChild, restRest);
            if (isLeftMatch) {
                System.out.println(root.data);
            }
        }
        boolean isRightMatch = false;
        if (root.rightChild != null) {
            isRightMatch = findPath(root.rightChild, restRest);
            if (isRightMatch) {
                System.out.println(root.data);
            }
        }

        return isLeftMatch || isRightMatch;
    }

    /**
     * 1、采用先序遍历，当到达叶子节点的时候判断是否满足条件
     * 2、满足则打印，不满足跳过
     * 3、出栈，然后看栈顶元素是否有右孩子，有右孩子循环1
     */
    public static void print2(TreeNode root, int sum) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int total = 0;
        subPrint2(root, sum, total, stack);
    }

    private static void subPrint2(TreeNode root, int sum, int curSum, Deque<TreeNode> stack) {
        stack.push(root);
        curSum += root.data;

        boolean isLeaf = root.leftChild == null && root.rightChild == null;
        if (isLeaf && sum == curSum) {
            Iterator<TreeNode> it = stack.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println("--- split line ---");
        }

        if (root.leftChild != null) {
            subPrint2(root.leftChild, sum, curSum, stack);
        }

        if (root.rightChild != null) {
            subPrint2(root.rightChild, sum, curSum, stack);
        }

        TreeNode poped = stack.pop();
        curSum -= poped.data;
    }


    public static void main(String[] args) {
        BinTreeInLink binTree = new BinTreeInLink(3);
        TreeNode t5 = binTree.add(binTree.root(), 5, true);
        TreeNode t7 = binTree.add(binTree.root(), 7, false);
        TreeNode t2 = binTree.add(t5, 2, true);
        TreeNode t1 = binTree.add(t5, 1, false);
        TreeNode t9 = binTree.add(t7, 8, false);
        binTree.add(t2, 8, true);
//        binTree.preOrder().forEach(System.out::println);
        print2(binTree.root(), 18);
    }
}
