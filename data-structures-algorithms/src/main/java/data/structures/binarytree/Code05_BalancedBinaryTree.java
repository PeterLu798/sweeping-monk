package data.structures.binarytree;

public class Code05_BalancedBinaryTree {
    public class Node {
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    //判断一颗二叉树是否是平衡二叉树
    public boolean isBBT(Node head) {
        return process(head).isBBT;
    }

    //套路法解题
    public class ReturnData {
        //递归套路法需要每一个子树返回以下信息
        //是否是平衡二叉树
        public boolean isBBT;
        //这棵树的高度
        public Integer height;

        public ReturnData(boolean isBBT, Integer height) {
            this.isBBT = isBBT;
            this.height = height;
        }
    }

    public ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(true, 0);
        }
        ReturnData left = process(head.left);
        ReturnData right = process(head.right);

//        boolean isBBT = true;
//        if (!left.isBBT || !right.isBBT) {
//            isBBT = false;
//        }
//        Integer height = Math.max(left.height, right.height) + 1;
//        if (Math.abs(left.height - right.height) > 2) {
//            isBBT = false;
//        }
        //把上面语句合并一下就是
        boolean isBBT = left.isBBT && right.isBBT && (Math.abs(left.height - right.height) < 2);
        Integer height = Math.max(left.height, right.height) + 1;

        return new ReturnData(isBBT, height);
    }
}
