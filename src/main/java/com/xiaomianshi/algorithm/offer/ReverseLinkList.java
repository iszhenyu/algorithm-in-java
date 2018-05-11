package com.xiaomianshi.algorithm.offer;

import com.xiaomianshi.algorithm.Common;

/**
 * @author zhen.yu
 * @since 2018/5/11
 */
public class ReverseLinkList {

    public static Common.LinkNode reverse(Common.LinkNode root) {
        Common.LinkNode res = null;
        Common.LinkNode left = root;
        Common.LinkNode right = root.next;
        while (right != null) {
            left.next = res;
            res = left;
            left = right;
            right = right.next;
        }
        left.next = res;
        res = left;
        return res;
    }

    public static void main(String[] args) {
        Common.LinkNode root = new Common.LinkNode(1);
        Common.LinkNode cur = root;
        cur.next = new Common.LinkNode(2);
        cur = cur.next;
        cur.next = new Common.LinkNode(3);
        cur = cur.next;
        cur.next = new Common.LinkNode(4);
        cur = cur.next;
        cur.next = new Common.LinkNode(5);
        root = reverse(root);
        cur = root;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

}
