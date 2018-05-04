package com.jianshuoschool.algorithm.tree;

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
        if (empty()) {
            return Collections.emptyList();
        }

        List<TreeNode> result = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        result.add(cur);
        stack.push(cur);

        while (cur != null && !stack.isEmpty()) {
            while (cur.leftChild != null) {
                cur = cur.leftChild;
                result.add(cur);
                stack.push(cur);
            }
            if (cur.rightChild != null) {
                cur = cur.rightChild;
                result.add(cur);
                stack.push(cur);
            } else {
                while (!stack.isEmpty()) {
                    cur = stack.pop();
                    if (cur.rightChild != null) {
                        cur = cur.rightChild;
                        result.add(cur);
                        stack.push(cur);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public List<TreeNode> inOrder2() {
        if (empty()) {
            return Collections.emptyList();
        }

        List<TreeNode> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        stack.push(cur);

        while (cur != null && !stack.isEmpty()) {
            while (cur.leftChild != null) {
                cur = cur.leftChild;
                stack.push(cur);
            }
            if (cur.rightChild != null) {
                cur = cur.rightChild;
                stack.push(cur);
            } else {
                while (!stack.isEmpty()) {
                    cur = stack.pop();
                    result.add(cur);
                    if (cur.rightChild != null) {
                        cur = cur.rightChild;
                        stack.push(cur);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public List<TreeNode> postOrder2() {
        if (empty()) {
            return Collections.emptyList();
        }

        Set<TreeNode> visited = new HashSet<>();
        List<TreeNode> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        stack.push(cur);

        while (cur != null && !stack.isEmpty()) {
            while (cur.leftChild != null) {
                cur = cur.leftChild;
                stack.push(cur);
            }
            if (cur.rightChild != null) {
                cur = cur.rightChild;
                stack.push(cur);
            } else {
                while (!stack.isEmpty()) {
                    TreeNode top = stack.peek();
                    if (top.rightChild == null) {
                        cur = stack.pop();
                        result.add(cur);
                    } else {
                        if (!visited.contains(top)) {
                            visited.add(top);
                            cur = top.rightChild;
                            stack.push(cur);
                            break;
                        } else {
                            cur = stack.pop();
                            result.add(cur);
                        }
                    }
                }
            }
        }

        return result;
    }
}




