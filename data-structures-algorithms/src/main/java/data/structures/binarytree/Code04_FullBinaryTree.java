package data.structures.binarytree;

public class Code04_FullBinaryTree {
    public class Node {
        public Integer value;
        public Node left;

        public Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    //判断一颗二叉树是不是满二叉树
    public boolean isFBT(Node head) {
        Info info = process(head);
        return info.nodes == (1 << info.height - 1); // 2 ^ (info.height)等价于 1 << info.height

    }

    public class Info {
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public Info process(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info left = process(head.left);
        Info right = process(head.right);

        int height = Math.max(left.height, right.height) + 1;
        int nodes = left.nodes + right.nodes + 1;

        return new Info(height, nodes);
    }
}
