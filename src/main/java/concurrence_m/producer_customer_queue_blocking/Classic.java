package concurrence_m.producer_customer_queue_blocking;


import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 *
 * 使用同步队列来实现生产者消费者问题
 */

class ProducerQueue {
    private ArrayBlockingQueue<Product> linkedList = new ArrayBlockingQueue<Product>(5);


    public synchronized void put(Product product) throws InterruptedException {

        linkedList.put(product);
    }

    public  Product get() throws InterruptedException {
        return linkedList.take();
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
    private ProducerQueue producerQueue;

    public Producer(ProducerQueue producerQueue) {
        this.producerQueue = producerQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Product product = new Product();
                producerQueue.put(product);
                System.out.println("生产"+product.toString());
            }
        }
        catch (InterruptedException e){
                e.printStackTrace();
            }
    }
}

class Customer implements Runnable {
    private ProducerQueue producerQueue;

    public Customer(ProducerQueue producerQueue) {
        this.producerQueue = producerQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Product product=producerQueue.get();
                System.out.println("消费 " + product.toString());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Classic {


    public static void main(String[] args) throws InterruptedException {
        ProducerQueue producerQueue = new ProducerQueue();
        Producer producer = new Producer(producerQueue);
        Customer customer = new Customer(producerQueue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producer);
        executorService.execute(customer);
        executorService.shutdown();
        Thread.sleep(10);
        executorService.shutdownNow();
    }
}