package concurrence_m.producer_customer_queue;


import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static net.mindview.util.Print.print;

/**
 * 在producer_customer_imp包下
 * 生产者和消费者只能使用一个产品，
 * 现在将产品放入一个队列中，
 * 队列已满，生产者挂起，
 * 队列为空，消费者挂起
 *
 * 注意：
 * 生产者线程和消费者线程都在ProducerQueue这个对象上等待
 */

class ProducerQueue {
    private LinkedList<Product> linkedList = new LinkedList<>();
    private int queueSize = 10;

    public ProducerQueue(int queueSize) {
        this.queueSize = queueSize;
    }

    public synchronized void put(Product product) throws InterruptedException {

        while (linkedList.size() >= queueSize) {
            wait();
        }

        linkedList.offer(product);
        notifyAll();
        System.out.println("队列当前大小"+linkedList.size());
    }

    public synchronized Product get() throws InterruptedException {
        while (linkedList.size() <= 0) {
            wait();
        }

        Product pop = linkedList.pop();
        notifyAll();
        return pop;
    }
}

class Product {
    private static int count = 0;

    private int id;

    public Product() {
        this.id = count++;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                '}';
    }
}

class Producer implements Runnable {
    private Factory factory;

    public Producer(Factory factory) {
        this.factory = factory;
    }


    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Product product = new Product();
                factory.producerQueue.put(product);
                System.out.println("生产 " + product);
            }
        }
        catch (InterruptedException e){
                e.printStackTrace();
            }
    }
}

class Customer implements Runnable {
    private Factory factory;

    public Customer(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Product product = factory.producerQueue.get();
                System.out.println("消费 " + product.toString());
                System.out.println("------------");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Factory {
    ProducerQueue producerQueue;



    public Factory() {
    }
}

public class Classic {


    public static void main(String[] args) throws InterruptedException {
        Factory factory = new Factory();
        factory.producerQueue = new ProducerQueue(5);
        Producer producer = new Producer(factory);
        Customer customer = new Customer(factory);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producer);
        executorService.execute(customer);
        executorService.shutdown();
        Thread.sleep(10);
        executorService.shutdownNow();
    }
}