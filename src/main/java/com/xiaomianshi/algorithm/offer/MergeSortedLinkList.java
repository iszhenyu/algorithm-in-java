package com.xiaomianshi.algorithm.offer;

import com.xiaomianshi.algorithm.Common;

/**
 * @author zhen.yu
 * @since 2018/5/11
 */
public class MergeSortedLinkList {

    public static Common.LinkNode merge(Common.LinkNode link1, Common.LinkNode link2) {
        Common.LinkNode cur1 = link1;
        Common.LinkNode cur2 = link2;
        Common.LinkNode tail = null;
        Common.LinkNode res = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.data < cur2.data) {
                if (res == null) {
                    res = cur1;
                    tail = cur1;
                } else {
                    tail.next = cur1;
                    tail = tail.next;
                }
                cur1 = cur1.next;
            } else {
                if (res == null) {
                    res = cur2;
                    tail = cur2;
                } else {
                    tail.next = cur2;
                    tail = tail.next;
                }
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            tail.next = cur1;
            tail = null;
        }
        if (cur2 != null) {
            tail.next = cur2;
            tail = null;
        }
        return res;
    }

    public static Common.LinkNode merge2(Common.LinkNode link1, Common.LinkNode link2) {
        if (link1 == null) {
            return link2;
        } else if (link2 == null) {
            return link1;
        }
        Common.LinkNode mergedHead = null;
        if (link1.data < link2.data) {
            mergedHead = link1;
            mergedHead.next = merge2(link1.next, link2);
        } else {
            mergedHead = link2;
            mergedHead.next = merge2(link1, link2.next);
        }
        return mergedHead;
    }

    public static void main(String[] args) {
        Common.LinkNode root1 = new Common.LinkNode(1);
        Common.LinkNode cur = root1;
        cur.next = new Common.LinkNode(4);
        cur = cur.next;
        cur.next = new Common.LinkNode(7);
        cur = cur.next;
        cur.next = new Common.LinkNode(8);
        cur = cur.next;
        cur.next = new Common.LinkNode(11);

        Common.LinkNode root2 = new Common.LinkNode(2);
        cur = root2;
        cur.next = new Common.LinkNode(3);
        cur = cur.next;
        cur.next = new Common.LinkNode(4);
        cur = cur.next;
        cur.next = new Common.LinkNode(6);
        cur = cur.next;
        cur.next = new Common.LinkNode(9);

        Common.LinkNode root = merge2(root1, root2);
        cur = root;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

}
