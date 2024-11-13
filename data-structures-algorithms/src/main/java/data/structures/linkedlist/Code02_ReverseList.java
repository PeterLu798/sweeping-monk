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

    //反转一个单链表


    public static void main(String[] args) {
        Code02_ReverseList list = new Code02_ReverseList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        Node node6 = new Node(6);
        list.addHead(node6);
        list.list();

        Node remove = list.remove(8);
        System.out.println("删除的节点是：" + (remove != null ? remove.value : "null"));
        list.list();

        list.update(6, 0);
        list.update(5, 50);
        System.out.println("-------------");
        list.list();
    }
}
