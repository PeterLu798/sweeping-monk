package data.structures.linkedlist;

public class Code05_SmallerEqualBigger {
    final Node head = new Node(null);

    public static class Node {
        public Integer value;
        public Node next;

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

    public void list() {
        Node t = head;
        while (t.next != null) {
            System.out.println(t.next.value);
            t = t.next;
        }
    }

    /**
     * 将单链表按照pivot值分为小于-等于-大于的顺序
     *
     * @param head
     * @param pivot
     * @return
     */
    public static void listPartition(Node head, int pivot) {
        Node sh = null;  //小于部分的首节点
        Node st = null;  //小于部分的尾节点
        Node eh = null;  //等于部分的首节点
        Node et = null;  //等于部分的尾节点
        Node bh = null;  //大于部分的首节点
        Node bt = null;  //大于部分的尾节点 用不到
        //带头结点的
        Node t = head.next;
        Node next = null;
        while (t != null) {
            next = t.next;
            //这一步很关键
            t.next = null;
            if (t.value < pivot) {
                if (sh == null) {
                    sh = t;
                    st = t;
                } else {
                    st.next = t;
                    st = t;
                }
            } else if (t.value == pivot) {
                if (eh == null) {
                    eh = t;
                    et = t;
                } else {
                    et.next = t;
                    et = t;
                }
            } else {
                if (bh == null) {
                    bh = t;
                    bt = t;
                } else {
                    bt.next = t;
                    bt = t;
                }
            }
            t = next;
        }
        if (sh != null) {
            head.next = sh;
            if (eh != null) {
                st.next = eh;
                et.next = bh;
            } else {
                st.next = bh;
            }
        } else {
            if (eh != null) {
                head.next = eh;
                et.next = bh;
            } else {
                head.next = bh;
            }
        }
    }

    public static void main(String[] args) {
        Code05_SmallerEqualBigger bigger = new Code05_SmallerEqualBigger();
        bigger.add(new Node(40));
        bigger.add(new Node(70));
        bigger.add(new Node(30));
        bigger.add(new Node(50));
        bigger.add(new Node(60));
        bigger.add(new Node(20));
        bigger.add(new Node(10));
        bigger.add(new Node(50));

        bigger.list();

        System.out.println("----------------------------------");
        listPartition(bigger.head, 30);
        bigger.list();
    }
}
