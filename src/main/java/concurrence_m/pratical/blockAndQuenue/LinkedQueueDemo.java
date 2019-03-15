package concurrence_m.pratical.blockAndQuenue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * 链表队列
 */
public class LinkedQueueDemo<T> {

    public static void main(String[] args) {
        LinkedQueueDemo<String> linkedBlockingDeque = new LinkedQueueDemo<>();
        linkedBlockingDeque.enqueue("李浩");
        linkedBlockingDeque.enqueue("决明");
        String out1 = linkedBlockingDeque.dequeue();
        String out2 = linkedBlockingDeque.dequeue();
        String out3 = linkedBlockingDeque.dequeue();
        System.out.println(out1);
        System.out.println(out2);
        System.out.println(out3);
    }

    static class Node<T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head = null;
    private Node tail = null;

    public LinkedQueueDemo() {
        head = tail = new Node(null);
    }

    public void enqueue(T element) {
        Node newNode = new Node(element);
        tail.next = newNode;
        tail = tail.next;
    }

    public T dequeue() {
        if (head == tail) {
            return null;
        }
        T res = (T) head.next.value;
        head = head.next;
        return res;
    }

}
