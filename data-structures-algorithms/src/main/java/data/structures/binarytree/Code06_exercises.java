package data.structures.binarytree;

import java.util.*;

public class Code06_exercises {
    public class Node<V> {
        public V value;
        public Node left;
        public Node right;

        public Node(V value) {
            this.value = value;
        }
    }

    //给定二叉树的两个节点o1和o2，找到它们的最低公共祖先节点
    public Node lowestAncestor1(Node head, Node o1, Node o2) {
        Map<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);

        //
        Set<Node> set1 = new HashSet<>();
        Node cur = o1;
        while (cur != fatherMap.get(cur)) {
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);

        //
        cur = o2;
        while (cur != fatherMap.get(cur)) {
            if (set1.contains(cur)) {
                return cur;
            }
            cur = fatherMap.get(cur);
        }

        return head;
    }

    public void process(Node head, Map<Node, Node> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    //给定二叉树的两个节点o1和o2，找到它们的最低公共祖先节点
    public Node lowestAncestor2(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = lowestAncestor2(head.left, o1, o2);
        Node right = lowestAncestor2(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;

    }

    public class Node1 {
        public int value;
        public Node1 left;
        public Node1 right;
        public Node1 parent;

        public Node1(int value) {
            this.value = value;
        }
    }

    //查找节点node的后继节点
    public Node1 getSuccessorNode(Node1 node) {
        if (node == null) {
            return null;
        }
        //如果node有右子树
        if (node.right != null) {
            return getLeftmost(node.right);
        } else {
            //如果node没有右子树
            Node1 parent = node.parent;
            while (parent != null && parent.left != node) {//当前节点是其父亲的右孩子
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private Node1 getLeftmost(Node1 node1) {
        if (node1 == null) {
            return null;
        }
        while (node1.left != null) {
            node1 = node1.left;
        }
        return node1;
    }

    //二叉树的序列化（先序遍历的序列化）
    public String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    //二叉树的反序列化（先序遍历的反序列化）
    public Node reconByPreString(String preStr) {
        String[] split = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            queue.add(split[i]);
        }
        return reconPreOrder(queue);
    }

    private Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

}
