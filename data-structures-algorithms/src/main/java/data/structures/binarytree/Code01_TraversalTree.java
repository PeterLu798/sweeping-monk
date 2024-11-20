package data.structures.binarytree;

import java.util.*;

public class Code01_TraversalTree {

    public class Node<V> {
        public V value;
        public Node left;
        public Node right;

        public Node(V value) {
            this.value = value;
        }
    }

    /**
     * 递归序
     *
     * @param head
     */
    public void recursion(Node head) {
        if (head == null) {
            return;
        }
        recursion(head.left);
        recursion(head.right);
    }

    //非递归前序遍历
    public void preOrderTraversalTree(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.value);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    //非递归中序遍历
    public void inOrderTraversalTree(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }

    //非递归后序遍历
    public void postorderTraversalTree(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
    }

    //二叉树宽度优先遍历
    public void wideTraversalTree(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

    //求一颗二叉树的宽度
    public Integer widthOfBinaryTree(Node head) {
        if (head == null) {
            return 0;
        }
        Map<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        Integer curLevel = 1;
        Integer curLevelNodeNum = 0;
        Integer width = Integer.MIN_VALUE;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            Integer level = levelMap.get(head);
            if (level.equals(curLevel)) {
                curLevelNodeNum = curLevelNodeNum + 1;
            } else {
                width = Math.max(width, curLevelNodeNum);
                curLevel = curLevel + 1;
                curLevelNodeNum = 1;
            }
            if (head.left != null) {
                queue.add(head.left);
                levelMap.put(head.left, curLevel + 1);
            }
            if (head.right != null) {
                queue.add(head.right);
                levelMap.put(head.right, curLevel + 1);
            }
        }
        return width;
    }
}
