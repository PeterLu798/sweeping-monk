package data.structures.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code02_BinarySearchTree {
    public class Node {
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    //判断是否为二叉搜索树（利用递归中序遍历）
    private static Integer preValue = Integer.MIN_VALUE;

    public boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean leftIsBST = isBST(head.left);
        if (!leftIsBST) {
            return false;
        }
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return isBST(head.right);
    }

    //判断是否为二叉搜索树（简版的递归调用）
    public boolean isBST2(Node head) {
        List<Node> inOrderList = new ArrayList<>();
        process(head, inOrderList);
        if (inOrderList.isEmpty()) {
            return true;
        }
        Integer preValue = Integer.MIN_VALUE;
        for (Node node : inOrderList) {
            if (node.value <= preValue) {
                return false;
            } else {
                preValue = node.value;
            }
        }
        return true;
    }

    private void process(Node head, List<Node> inOrderList) {
        if (head == null) {
            return;
        }
        process(head.left, inOrderList);
        inOrderList.add(head);
        process(head.right, inOrderList);
    }

    //判断是否为二叉搜索树（非递归中序遍历法）
    public boolean isBST3(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Integer preValue = Integer.MIN_VALUE;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.value <= preValue) {
                    return false;
                } else {
                    preValue = head.value;
                }
                head = head.right;
            }
        }
        return true;
    }

    public boolean isBST4(Node head) {
        return process(head).isBST;
    }

    public class ReturnData {
        public boolean isBST;
        public Integer minValue;
        public Integer maxValue;

        public ReturnData(boolean isBST, Integer minValue, Integer maxValue) {
            this.isBST = isBST;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    public ReturnData process(Node head) {
        if (head == null) {
            //套路一：如果head为空情况下返回值不能确定，那么返回null
            return null;
        }
        ReturnData leftReturnData = process(head.left);
        ReturnData rightReturnData = process(head.right);

        //默认为true
        boolean isBST = true;
        Integer minValue = head.value;
        Integer maxValue = head.value;
        if (leftReturnData != null) {
            minValue = Math.min(minValue, leftReturnData.minValue);
            maxValue = Math.max(maxValue, leftReturnData.maxValue);
        }
        if (rightReturnData != null) {
            minValue = Math.min(minValue, rightReturnData.minValue);
            maxValue = Math.max(maxValue, rightReturnData.maxValue);
        }
        //开始进入逻辑
        if (leftReturnData != null && !leftReturnData.isBST) {
            isBST = false;
        }
        if (rightReturnData != null && !rightReturnData.isBST) {
            isBST = false;
        }
        if (leftReturnData != null && leftReturnData.maxValue >= head.value) {
            isBST = false;
        }
        if (rightReturnData != null && head.value >= rightReturnData.minValue) {
            isBST = false;
        }
        return new ReturnData(isBST, minValue, maxValue);
    }
}
