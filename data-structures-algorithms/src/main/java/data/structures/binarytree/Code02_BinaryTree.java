package data.structures.binarytree;

public class Code02_BinaryTree {
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
}
