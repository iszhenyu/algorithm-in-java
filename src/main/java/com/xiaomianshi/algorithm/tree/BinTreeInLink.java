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
     * 后序遍历可以看做是从右到左的先序遍历的逆过程，所以可以利用辅助栈，
     * 按照从右至左的先序遍历，遍历的结果存到辅助栈里，然后将辅助栈的元素依次出栈
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
     * 非递归后序遍历
     *
     * 对于任一结点P，将其入栈，然后沿其左子树一直往下搜索，直到搜索到没有左孩子的结点，
     * 此时该结点出现在栈顶，但是此时不能将其出栈并访问，因为其右孩子还为被访问。
     * 所以，接下来按照相同的规则对其右子树进行相同的处理，
     * 当访问完其右孩子时，该结点又出现在栈顶，此时可以将其出栈并访问。
     * 在这个过程中，每个结点都两次出现在栈顶，只有在第二次出现在栈顶时，才能访问它。
     */
    public List<TreeNode> postOrder3() {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<TreeNode, Boolean> visitedNodes = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                visitedNodes.put(cur, true);
                stack.push(cur);
                cur = cur.leftChild;
            }

            if (!stack.isEmpty()) {
                cur = stack.pop();
                if (visitedNodes.get(cur)) {
                    visitedNodes.put(cur, false);
                    stack.push(cur);
                    cur = cur.rightChild;
                } else {
                    result.add(cur);
                    cur = null;
                }
            }
        }
        return result;
    }

    /**
     * 对于任一结点P，先将其入栈。
     * 如果P不存在左孩子和右孩子，则可以直接访问它；
     * 或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
     * 若非上述两种情况，则将P的右孩子和左孩子依次入栈，
     * 这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
     */
    public List<TreeNode> postOrder4() {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        TreeNode pre = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            // 1）叶子节点直接访问
            // 2）如果当前节点要被加到result中，则一定满足：
            //     1、左子节点刚刚被添加（没有右子几点的情况）
            //     2、右子节点刚刚被添加（有或没有左子节点）
            if ((cur.leftChild == null && cur.rightChild == null) ||
                    (pre != null && (pre == cur.leftChild || pre == cur.rightChild))) {
                result.add(cur);
                stack.pop();
                pre = cur;
            } else {
                if (cur.rightChild != null) {
                    stack.push(cur.rightChild);
                }
                if (cur.leftChild != null) {
                    stack.push(cur.leftChild);
                }
            }
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

    /**
     * 遍历指定的层
     */
    public List<TreeNode> visitSpecifiedLevel(int level) {
        if (level <= 0 || root == null) {
            return Collections.emptyList();
        }

        List<TreeNode> result = new ArrayList<>();
        TreeNode cur = root;
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(cur);
        levelMap.put(cur, 1);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            int curLevel = levelMap.get(cur);
            if (curLevel == level) {
                result.add(cur);
            } else if (curLevel < level) {
                if (cur.leftChild != null) {
                    queue.add(cur.leftChild);
                    levelMap.put(cur.leftChild, curLevel + 1);
                }
                if (cur.rightChild != null) {
                    queue.add(cur.rightChild);
                    levelMap.put(cur.rightChild, curLevel + 1);
                }
            } else {
                break;
            }
        }
        return result;
    }

    public List<TreeNode> visitSpecifiedLevel2(int level) {
        if (level <= 0 || root == null) {
            return Collections.emptyList();
        }
        return subVisit(Collections.singletonList(root), level, 1);
    }

    public List<TreeNode> subVisit(List<TreeNode> parentNodes, int level, int curLevel) {
        if (level == curLevel) {
            return parentNodes;
        } else {
            List<TreeNode> result = new ArrayList<>();
            for (TreeNode node: parentNodes) {
                if (node.leftChild != null) {
                    result.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    result.add(node.rightChild);
                }
            }
            return subVisit(result, level, curLevel + 1);
        }
    }
}




