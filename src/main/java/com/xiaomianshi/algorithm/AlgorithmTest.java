package com.xiaomianshi.algorithm;

import com.xiaomianshi.algorithm.sort.*;
import com.xiaomianshi.algorithm.tree.BinTreeInLink;
import com.xiaomianshi.algorithm.tree.TreeNode;

import java.util.List;

/**
 * @author zhen.yu
 * @since 2018/5/3
 */
public class AlgorithmTest {

    public static void main(String[] args) {
//        int[] arr = new int[]{3, 5, 7, 2, 3, 1, 9};
//        testSort(arr);
//        testCountingSort(arr);
//        testTreeTraversing();
//        testRedBag();
//        testConversion();
//        testLargeInteger();
//        testRebuildTree();
        test();
    }

    private static void test() {
        System.out.println(SpinArray.min3(new int[]{4, 5, 1, 2, 3}));
    }

    private static void testRebuildTree() {
        TreeNode root = RebuildBinTree.rebuild(RebuildBinTree.PRE_ORDER, RebuildBinTree.IN_ORDER);
        printTree(root);
    }

    private static void printTree(TreeNode root) {
        System.out.println(root.data);
        if (root.leftChild != null) {
            printTree(root.leftChild);
        }
        if (root.rightChild != null) {
            printTree(root.rightChild);
        }
    }

    private static void testLargeInteger() {
        System.out.println(LargeInteger.multiply("140", "110"));
    }

    private static void testConversion() {
        String numStr = "1101";
        long num = 13L;
        System.out.println(HexadecimalConversion.c16To2("3d"));
    }

    private static void testRedBag() {
        System.out.println(RedBag.randomAssign2(100, 10));
    }

    private static void testTreeTraversing() {
        BinTreeInLink binTree = new BinTreeInLink(3);
        TreeNode t5 = binTree.add(binTree.root(), 5, true);
        TreeNode t7 = binTree.add(binTree.root(), 7, false);
        TreeNode t2 = binTree.add(t5, 2, true);
        TreeNode t1 = binTree.add(t5, 1, false);
        TreeNode t9 = binTree.add(t7, 9, false);
        binTree.add(t2, 8, true);
        List<TreeNode> result = binTree.postOrder4();
        System.out.println(result);
    }

    private static void testSort(int[] arr) {
        printArr(arr);
        RadixSort.lsdSort(arr);
        printArr(arr);
    }

    private static void testCountingSort(int[] arr) {
        int[] result = new int[arr.length];
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        printArr(arr);
        CountingSort.sort(arr, result, maxVal);
        printArr(result);
    }

    private static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder("Array::[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != (arr.length - 1)) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
