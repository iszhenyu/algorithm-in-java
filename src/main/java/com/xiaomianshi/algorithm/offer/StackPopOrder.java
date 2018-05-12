package com.xiaomianshi.algorithm.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhen.yu
 * @since 2018/5/11
 *
 * 给定两个整数序列，一个表示栈的压入顺序，判断令一个是否表示栈的弹出顺序
 */
public class StackPopOrder {

    public static boolean isPopOrder(int[] inOrder, int[] outOrder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int size = inOrder.length;
        int curIn = 0;
        for (int i = 0; i < outOrder.length; i++) {
            while (stack.isEmpty() || stack.peek() != outOrder[i]) {
                if (curIn >= size) {
                    return false;
                }
                stack.push(inOrder[curIn]);
                curIn++;
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 3, 4, 5};
        int[] out = new int[]{4, 3, 5, 1, 2};
        System.out.println(isPopOrder(in, out));
    }

}
