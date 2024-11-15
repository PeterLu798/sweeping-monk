package data.structures.linkedlist;

public class Code02_2_ReverseLinkList {
    public static class LinkNode {
        public Integer data;
        public LinkNode pre;
        public LinkNode next;

        public LinkNode(Integer data) {
            this.data = data;
        }
    }

    //头节点
    final LinkNode head = new LinkNode(null);

    //遍历打印双链表
    public void list() {
        LinkNode t = head;
        while (t.next != null) {
            System.out.println(t.next.data);
            t = t.next;
        }
    }

    //双向链表头插法
    public void addHead(LinkNode linkNode) {
        if (linkNode == null) {
            return;
        }
        linkNode.next = head.next;
        linkNode.pre = head;

        if (head.next != null) {
            head.next.pre = linkNode;
        }

        head.next = linkNode;
    }

    //双向链表尾插法
    public void addEnd(LinkNode linkNode) {
        if (linkNode == null) {
            return;
        }
        LinkNode t = head;
        while (t.next != null) {
//            System.out.println(111);
            t = t.next;
        }
        t.next = linkNode;
        linkNode.pre = t;
    }

    public void addEnd2(LinkNode linkNode) {
        if (linkNode == null) {
            return;
        }
        LinkNode t = head;
        //这种写法效率比上面低，因为每回进来都要进while循环
        while (true) {
//            System.out.println(111);
            if (t.next == null) {
                t.next = linkNode;
                linkNode.pre = t;
                break;
            }
            t = t.next;
        }
    }

    //双链表删除
    public void remove(Integer data) {
        LinkNode t = head;
        while (t.next != null) {
            if (t.next.data.equals(data)) {
                if (t.next.next != null) {
                    t.next.next.pre = t.next;
                }
                t.next = t.next.next;
                break;
            }
            t = t.next;
        }
    }

    //双链表修改
    public void update(Integer data, Integer updateData) {
        LinkNode t = head;
        while (t.next != null) {
            if (t.next.data.equals(data)) {
                t.next.data = updateData;
                break;
            }
            t = t.next;
        }
    }

    //双链表反转
    public void reverseLinkedList(LinkNode head) {

    }

    public static void main(String[] args) {
        Code02_2_ReverseLinkList linkList = new Code02_2_ReverseLinkList();
        LinkNode linkNode1 = new LinkNode(10);
        LinkNode linkNode2 = new LinkNode(20);
        LinkNode linkNode3 = new LinkNode(30);
        LinkNode linkNode4 = new LinkNode(40);
        LinkNode linkNode5 = new LinkNode(50);

        linkList.addEnd(linkNode1);
        linkList.addEnd(linkNode2);
        linkList.addEnd(linkNode3);
        linkList.addEnd(linkNode4);
        linkList.addEnd(linkNode5);

        linkList.list();

        linkList.remove(50);
        System.out.println("-------------");
//        linkList.list();

        linkList.update(40, 50);
        System.out.println("------------");
//        linkList.list();

        LinkNode ln3 = new LinkNode(3);
        LinkNode ln6 = new LinkNode(6);
        linkList.addHead(ln3);
        linkList.addHead(ln6);

        linkList.list();

//        linkList.reverseLinkedList(linkList.head);
//        System.out.println("---------反转后---------");
//        linkList.list();

    }

}
