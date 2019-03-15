package dataStruct;

/**
 * 按照插入顺序维护链表
 */


public class LinkedListInsertOrder {
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
    Node last = header;


    public void insert(int value) {
        Node newNode = new Node(last, null, value);
        last.next = newNode;
        last = newNode;
    }


    public void delete(int value) {
        Node p = header;
        while (p.next != null) {
            if (value == p.next.value) {
                p.next=p.next.next;
                if(p.next!=null&&p.next.next!=null) {//剔除最后一个点
                    p.next.next.before = p;
                }
                break;
            }
            p=p.next;
        }
    }

    public int get(int position){
        int index=0;
        Node p=header.next;
        while(p!=null){
            if(index==position){
                return p.value;
            }
            index++;
        }
        return -1;
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
        LinkedListInsertOrder linkedListInsertOrder = new LinkedListInsertOrder();
        linkedListInsertOrder.insert(1);
        linkedListInsertOrder.insert(2);
        linkedListInsertOrder.insert(3);
        linkedListInsertOrder.insert(4);
        linkedListInsertOrder.insert(5);
        linkedListInsertOrder.delete(5);
        linkedListInsertOrder.delete(2);
        linkedListInsertOrder.toString();
    }


}
