package dataStruct;

/**
 * 按照访问6顺序维护链表
 */


public class LinkedListAccessOrder {
    class Node {
        Node before = null;
        Node next = null;
        int value = 0;

        public Node() {
        }

        public Node(Node beforeNode, Node afterNode, int value) {
            this.before = beforeNode;
            this.next = afterNode;
            this.value = value;
        }
    }

    Node header = new Node();


    public void insert(int value) {
        Node newNode = new Node(null, null, value);
        newNode.before = header;
        newNode.next = header.next;
        Node originNext = header.next;
        header.next = newNode;
        if (originNext != null) {
            originNext.before = newNode;
        }
    }


    public void delete(int value) {
        Node p = header;
        while (p.next != null) {
            if (value == p.next.value) {
                p.next = p.next.next;
                if (p.next != null && p.next.next != null) {//剔除最后一个点
                    p.next.next.before = p;
                }
                break;
            }
            p = p.next;
        }
    }

    public int get(int position) {
        int index = 0;
        int res = -1;
        Node p = header.next;
        while (p != null) {
            if (index == position) {
                res = p.value;
                break;
            }
            index++;
            p = p.next;
        }

        // 原地删除

        Node pBefore = p.before;
        Node pAfter = p.next;
        pBefore.next = pAfter;
        if (pAfter != null) {
            pAfter.before = pBefore;
        }

        //插入到头部
        Node originHeaderAfter = header.next;
        header.next = p;
        p.before = header;

        p.next = originHeaderAfter;
        originHeaderAfter.before = p;


        return res;
    }


    @Override
    public String toString() {
        Node p = header;
        while (p.next != null) {
            System.out.println("p :" + p.next.value);
            p = p.next;
        }
        return super.toString();
    }

    public static void main(String[] args) {
        LinkedListAccessOrder linkedListInsertOrder = new LinkedListAccessOrder();
        linkedListInsertOrder.insert(1);
        linkedListInsertOrder.insert(2);
        linkedListInsertOrder.insert(3);
        linkedListInsertOrder.insert(4);
        linkedListInsertOrder.get(2);

        linkedListInsertOrder.toString();
    }


}
