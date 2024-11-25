package data.structures.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Code03_CompleteBinaryTree {

    public class Node<V> {
        public V value;
        public Node left;
        public Node right;

        public Node(V value) {
            this.value = value;
        }
    }

    //判断一棵二叉树是否完全二叉树
    public boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        //左右孩子不全
        boolean leaf = false;
        while (!queue.isEmpty()) {
            head = queue.poll();

            if (head.left == null && head.right != null) {
                return false;
            }
            if (leaf && head.left != null) {
                return false;
            }

            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
            if (head.left == null || head.right == null) {
                leaf = true;
            }
        }
        return true;
    }
}
