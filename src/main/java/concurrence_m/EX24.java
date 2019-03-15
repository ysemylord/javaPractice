package concurrence_m;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EX24 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        Queue queue = new Queue();
        executorService.execute(new Producer(queue));
        executorService.execute(new Consumor(queue));
        Thread.sleep(2000);
        executorService.shutdownNow();
    }
}

class Item {
   private static int count=0;
   private int id;

    public Item() {
        this.id =count++;
    }

    @Override
    public String toString() {
        return "item is "+id;
    }
}

class Queue<T> extends LinkedList {
    private int maxSize = 10;

    public synchronized void put(T item) throws InterruptedException {
        if (size() >= maxSize) {
            wait();
        }
        offer(item);
        maxSize++;
        System.out.println("生产商品"+item);
        notifyAll();//通知消费者，消费产品
    }

    public synchronized T get() throws InterruptedException {
        if (size() <= 0) {
            wait();
        }

        T item = (T) poll();
        maxSize--;
        System.out.println("消费商品"+item);
        notifyAll();//通知生产者，生产商品
        return item;
    }
}
class Producer implements Runnable{
    private Queue<Item> queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                queue.put(new Item());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}

class Consumor implements Runnable{
    private Queue<Item> queue;

    public Consumor(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            Item item = null;
            try {
                item =  queue.get();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
