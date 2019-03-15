package concurrence_m.pratical.blockAndQuenue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用链表实现的有界阻塞队列
 */
public class LinkedBlockingQueueDemo<T> {

    public static void main(String[] args) {

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

    private int capacity;
    private AtomicInteger count;//队列规模

    private ReentrantLock takeLock = new ReentrantLock();
    private Condition not_empty = takeLock.newCondition();
    private ReentrantLock putLock = new ReentrantLock();
    private Condition not_full = putLock.newCondition();

    public LinkedBlockingQueueDemo(int capacity) {
        head = tail = new Node(null);
        this.capacity = capacity;
        count = new AtomicInteger();
    }

    public LinkedBlockingQueueDemo() {
        new LinkedBlockingQueueDemo(Integer.MAX_VALUE);
    }

    public void put(T ele) throws InterruptedException {
        putLock.lockInterruptibly();
        int c = -1;
        try {
            while (count.get() == capacity) {//队列已满
                not_full.await();//调用put方法的线程在putLock锁上的not_empty等待队列上等待
            }
            enqueue(ele);//放入元素
            c = count.getAndIncrement();


            if (c + 1 < capacity) {//如果还可以放入，则唤醒在not_full队列中等待的线程
                not_full.signal();
            }

        } finally {
            putLock.unlock();
        }
        if (c == 0) {//原来队列规模为0，则唤醒在not_empty队列中等待的线程(这一部必须有，不然not_empty队列中的线程不会被唤醒)
            takeLock.lockInterruptibly();
            try {
                not_empty.await();
            } finally {
                takeLock.unlock();
            }
        }
    }

    public T get() throws InterruptedException {
        takeLock.lockInterruptibly();
        T res;
        int c=-1;
        try {
             while(count.get()==0){//队列为空
                 not_empty.await();//线程进入not_empty等待队列中等待
             }
             res=dequeue();
             c=count.getAndDecrement();
             if(c-1>0){//还可以获取元素
                 not_empty.signal();
             }
        } finally {
            takeLock.unlock();
        }

        if(c==capacity) {//原来队列是满的
            putLock.lockInterruptibly();
            try {
                not_full.signal();//唤醒在not_full队列中等待的线程，让你放入元素
            } finally {
                putLock.unlock();
            }
        }
        return res;
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
