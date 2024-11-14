package data.structures.linkedlist;

public class Code02_ReverseList {

    //定义一个带头节点的单链表，所谓带头节点就是头节点不存放数据，只包含一个指向下一个节点的指针（同理可知不带头节点就是链表的第一个节点存放数据）
    final Node head = new Node(null);

    public static class Node {
        public Integer value;
        public Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    //单链表增：在链表尾部增加节点
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

    //头插入
    public Node addHead(Node add) {
        if (add == null) {
            return head;
        }
        Node t = head.next;
        head.next = add;
        add.next = t;
        return head;
    }

    //单链表删
    public Node remove(Integer value) {
        if (head.next == null) {
            return null;
        }
        Node t = head;
        Node remove = null;
        while (t.next != null) {
            if (t.next.value.equals(value)) {
                remove = t.next;
                t.next = t.next.next;
                break;
            }
            t = t.next;
        }
        return remove;
    }

    //单链表改
    public boolean update(Integer value, Integer updateValue) {
        if (head.next == null) {
            return false;
        }
        Node t = head;
        boolean isSuc = false;
        while (t.next != null) {
            if (t.next.value.equals(value)) {
                isSuc = true;
                t.next.value = updateValue;
                break;
            }
            t = t.next;
        }
        return isSuc;
    }

    //单链表查

    //打印单链表
    public void list() {
        Node t = head;
        while (t.next != null) {
            System.out.println(t.next.value);
            t = t.next;
        }
    }

    //反转一个单链表：原地反转
    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node beg = head.next;
        Node end = head.next.next;
        while (end != null) {
            beg.next = end.next;
            end.next = head.next; //这步最难，不能写为end.next = beg;
            head.next = end;
            end = beg.next;
        }
        return head;
    }

    //反转一个单链表：头插法
    public Node reverseList2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p = head.next;
        head.next = null;

        while (p != null) {
            Node q = p.next;
            p.next = head.next; //这步最难
            head.next = p;
            p = q;
        }
        return head;
    }

    public static void main(String[] args) {
//        Code02_ReverseList list = new Code02_ReverseList();
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        list.add(node1);
//        list.add(node2);
//        list.add(node3);
//        list.add(node4);
//        list.add(node5);
//        Node node6 = new Node(6);
//        list.addHead(node6);
//        list.list();
//
//        Node remove = list.remove(8);
//        System.out.println("删除的节点是：" + (remove != null ? remove.value : "null"));
//        list.list();
//
//        list.update(6, 0);
//        list.update(5, 50);
//        System.out.println("-------------");
//        list.list();
//
//        list.reverseList(list.head);
//        System.out.println("---------反转之后------------");
//        list.list();


        Code02_ReverseList list1 = new Code02_ReverseList();
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);
        list1.add(node11);
        list1.add(node12);
        list1.add(node13);
        list1.add(node14);
        list1.add(node15);
        list1.list();
        System.out.println("--------------反转之后-------------");
        list1.reverseList2(list1.head);
        list1.list();
    }
}
