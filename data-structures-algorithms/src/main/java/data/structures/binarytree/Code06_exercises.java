package data.structures.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
}
