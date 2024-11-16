package data.structures.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Code06_CopyList {

    final Node head = new Node(null);

    public static class Node {
        public Integer value;
        public Node next;
        public Node rand;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public Node add(Node add) {
        if (add == null) {
            return head;
        }
        Node t = head;
        while (t.next != null) {
            t = t.next;
        }
        t.next = add;
        return head;
    }

    public static void list(Node head) {
        Node t = head;
        while (t.next != null) {
            System.out.println(t.next.value);
            t = t.next;
        }
    }

    public static Node copy(Node head) {
        Node t = head;
        Map<Node, Node> map = new HashMap<>();
        while (t != null) {
            Node tCopy = new Node(t.value);
            map.put(t, tCopy);
            t = t.next;
        }
        t = head;
        while (t != null) {
            map.get(t).next = map.get(t.next);
            map.get(t).rand = map.get(t.rand);
            t = t.next;
        }
        return map.get(head);
    }

    public static Node copy2(Node head) {
        Node t = head;
        Node next = null;
        while (t != null) {
            next = t.next;
            Node tCopy = new Node(t.value);
            tCopy.next = next;
            t.next = tCopy;
            t = next;
        }
        t = head;
        while (t != null && t.next != null) {
            t.next.rand = (t.rand != null ? t.rand.next : null);
            t = t.next.next;
        }
        t = head;
        Node copyHead = head.next;
        Node p = null;
        Node q = null;
        while (t != null) {
            p = t.next;
            q = t.next.next;
            t.next = q;
            p.next = q != null ? q.next : null;
            t = q;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        Code06_CopyList copyList = new Code06_CopyList();
        Node node10 = new Node(10);
        copyList.add(node10);
        copyList.add(new Node(20));
        Node node30 = new Node(30);
        copyList.add(node30);
        copyList.add(new Node(50));
        Node node55 = new Node(55);
        copyList.add(node55);
        node10.rand = node55;
        node30.rand = node10;
        Node head = copyList.head;
        while (head != null) {
            System.out.println(head.value + "  rand节点是  " + (head.rand != null ? head.rand.value : "null"));
            head = head.next;
        }
        System.out.println("----------copy----------");
        Node copy = copy(copyList.head);
        while (copy != null) {
            System.out.println(copy.value + "  rand节点是  " + (copy.rand != null ? copy.rand.value : "null"));
            copy = copy.next;
        }
        System.out.println("===================开始测试copy2方法===================");
        Code06_CopyList copyList1 = new Code06_CopyList();
        Node node1 = new Node(10);
        copyList1.add(node1);
        copyList1.add(new Node(20));
        Node node3 = new Node(30);
        copyList1.add(node3);
        copyList1.add(new Node(50));
        Node node550 = new Node(55);
        copyList1.add(node550);
        node1.rand = node550;
        node3.rand = node1;
        Node head1 = copyList1.head;
        while (head1 != null) {
            System.out.println(head1.value + "  rand节点是  " + (head1.rand != null ? head1.rand.value : "null"));
            head1 = head1.next;
        }
        System.out.println("----------copy----------");
        Node copy1 = copy2(copyList1.head);
        while (copy1 != null) {
            System.out.println(copy1.value + "  rand节点是  " + (copy1.rand != null ? copy1.rand.value : "null"));
            copy1 = copy1.next;
        }

    }
}
