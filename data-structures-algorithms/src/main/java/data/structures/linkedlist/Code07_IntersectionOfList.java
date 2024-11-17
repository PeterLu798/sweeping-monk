package data.structures.linkedlist;

import java.util.HashSet;

public class Code07_IntersectionOfList {

    public static class Node {
        public Integer value;
        public Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    //判断一个单链表是否有环，如果有返回入环节点
    public static Node hasLoop(Node head) {
        Node t = head;
        HashSet<Node> hashSet = new HashSet<>();
        while (t != null) {
            if (hashSet.contains(t)) {
                return t;
            }
            hashSet.add(t);
            t = t.next;
        }
        return null;
    }

    //判断一个单链表是否有环，如果有返回入环节点
    public static Node hasLoop2(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public Node getIntersectionOfTwoList(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = hasLoop2(head1);
        Node loop2 = hasLoop2(head2);
        if (loop1 == null && loop2 == null) {
            return getIntersectionWithNoLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            return getIntersectionWithLoop(head1, head2, loop1, loop2);
        } else {
            return null;
        }
    }

    public static Node getIntersectionWithNoLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = 0, len2 = 0;
        Node t1 = head1;
        while (t1.next != null) {
            len1 = len1 + 1;
            t1 = t1.next;
        }
        Node t2 = head2;
        while (t2.next != null) {
            len2 = len2 + 1;
            t2 = t2.next;
        }
        if (t1 != t2) {
            return null;
        }
        //把长的赋给t1，短的赋给t2
        if (len1 >= len2) {
            t1 = head1;
            t2 = head2;
        } else {
            t1 = head2;
            t2 = head1;
        }
        int n = Math.abs(len1 - len2);
        while (n != 0) {
            n = n - 1;
            t1 = t1.next;
        }
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;
    }

    public static Node getIntersectionWithLoop(Node head1, Node head2, Node loop1, Node loop2) {
        if (loop1 == loop2) {
            int len1 = 0, len2 = 0;
            Node t1 = head1;
            while (t1 != loop1) {
                len1 = len1 + 1;
                t1 = t1.next;
            }
            Node t2 = head2;
            while (t2 != loop2) {
                len2 = len2 + 1;
                t2 = t2.next;
            }
            //把长的赋给t1，短的赋给t2
            if (len1 >= len2) {
                t1 = head1;
                t2 = head2;
            } else {
                t1 = head2;
                t2 = head1;
            }
            int n = Math.abs(len1 - len2);
            while (n != 0) {
                n = n - 1;
                t1 = t1.next;
            }
            while (t1 != t2) {
                t1 = t1.next;
                t2 = t2.next;
            }
            return t1;
        } else {
            Node t = loop1.next;
            while (t != loop1) {
                if (t == loop2) {
                    return loop1;
                }
                t = t.next;
            }
            return null;
        }
    }


}
