package com.xiaomianshi.algorithm.tree;

import java.util.*;

/**
 * @author zhen.yu
 * @since 2018/4/8
 *
 * 二叉树链表存储
 */
public class BinTreeInLink {

    private TreeNode root;

    public BinTreeInLink() {
    }

    public BinTreeInLink(Integer data) {
        this.root = new TreeNode(data);
    }

    public TreeNode addRoot(Integer data) {
        this.root = new TreeNode(data);
        return this.root;
    }

    public TreeNode add(TreeNode parent, Integer data, boolean left) {
        if (parent == null) {
            throw new RuntimeException();
        }
        if (left && parent.leftChild != null) {
            throw new RuntimeException();
        }
        if (!left && parent.rightChild != null) {
            throw new RuntimeException();
        }

        TreeNode node = new TreeNode(data);
        if (left) {
            parent.leftChild = node;
        } else {
            parent.rightChild = node;
        }
        return node;
    }

    public boolean empty() {
        return this.root == null;
    }

    public TreeNode root() {
        if (empty()) {
            throw new RuntimeException();
        }
        return this.root;
    }

    public TreeNode parent(TreeNode node) {
        return null;
    }

    public Integer leftChild(TreeNode parent) {
        if (parent == null) {
            throw new RuntimeException();
        }
        return parent.leftChild == null ? null : parent.leftChild.data;
    }

    public Integer rightChild(TreeNode parent) {
        if (parent == null) {
            throw new RuntimeException();
        }
        return parent.rightChild == null ? null : parent.rightChild.data;
    }

    public int deep() {
        return deep(root);
    }

    private int deep(TreeNode parent) {
        int leftDeep = 0;
        int rightDeep = 0;
        if (parent.leftChild != null) {
            leftDeep = deep(parent.leftChild);
        }
        if (parent.rightChild != null) {
            rightDeep = deep(parent.rightChild);
        }
        return leftDeep > rightDeep ? rightDeep + 1 : leftDeep + 1;
    }

    private int fullSize() {
        return (int)Math.pow(2, deep()) - 1;
    }

    /**
     * 递归前序遍历
     * @return List
     */
    public List<TreeNode> preOrder() {
        List<TreeNode> result = new ArrayList<>(fullSize());
        preIter(root, result);
        return result;
    }

    private void preIter(TreeNode parent, List<TreeNode> result) {
        result.add(parent);
        if (parent.leftChild != null) {
            preIter(parent.leftChild, result);
        }
        if (parent.rightChild != null) {
            preIter(parent.rightChild, result);
        }
    }

    /**
     * 递归中序遍历
     * @return List
     */
    public List<TreeNode> inOrder() {
        List<TreeNode> result = new ArrayList<>(fullSize());
        inIter(root, result);
        return result;
    }

    private void inIter(TreeNode parent, List<TreeNode> result) {
        if (parent.leftChild != null) {
            inIter(parent.leftChild, result);
        }
        result.add(parent);
        if (parent.rightChild != null) {
            inIter(parent.rightChild, result);
        }
    }

    /**
     * 递归后序遍历
     * @return List
     */
    public List<TreeNode> postOrder() {
        List<TreeNode> result = new ArrayList<>(fullSize());
        postIter(root(), result);
        return result;
    }

    private void postIter(TreeNode parent, List<TreeNode> result) {
        if (parent.leftChild != null) {
            postIter(parent.leftChild, result);
        }
        if (parent.rightChild != null) {
            postIter(parent.rightChild, result);
        }
        result.add(parent);
    }

    /**
     * 前序非递归遍历
     * @return List
     */
    public List<TreeNode> preOrder2() {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            // 持续遍历左子树，直到左子树为空
            while (cur != null) {
                result.add(cur);
                stack.push(cur);
                cur = cur.leftChild;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur = cur.rightChild;
            }
        }

        return result;
    }

    public List<TreeNode> preOrder3() {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            result.add(cur);
            if (cur.rightChild != null) {
                stack.push(cur.rightChild);
            }
            if (cur.leftChild != null) {
                stack.push(cur.leftChild);
            }
        }

        return result;
    }

    /**
     * 中序非递归遍历
     */
    public List<TreeNode> inOrder2() {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftChild;
            }

            if (!stack.isEmpty()) {
                cur = stack.pop();
                result.add(cur);
                cur = cur.rightChild;
            }
        }

        return result;
    }

    /**
     * 非递归后序遍历
     *
     * 因为后序遍历可以看做，从右到左的先序遍历的逆过程，所以可以利用辅助栈
     */
    public List<TreeNode> postOrder2() {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        Deque<TreeNode> assistStack = new ArrayDeque<>();
        Deque<TreeNode> outputStack = new ArrayDeque<>();
        assistStack.push(cur);

        while (!assistStack.isEmpty()) {
            cur = assistStack.pop();
            outputStack.push(cur);
            if (cur.leftChild != null) {
                assistStack.push(cur.leftChild);
            }
            if (cur.rightChild != null) {
                assistStack.push(cur.rightChild);
            }
        }

        while (!outputStack.isEmpty()) {
            cur = outputStack.pop();
            result.add(cur);
        }
        return result;
    }

    /**
     * 按层遍历
     */
    public List<TreeNode> deepOrder() {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(cur);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            result.add(cur);
            if (cur.leftChild != null) {
                queue.add(cur.leftChild);
            }
            if (cur.rightChild != null) {
                queue.add(cur.rightChild);
            }
        }
        return result;
    }
}




