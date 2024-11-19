package data.structures.binarytree;

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
}
