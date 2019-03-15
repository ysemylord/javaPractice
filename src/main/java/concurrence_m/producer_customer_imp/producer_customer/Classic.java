package concurrence_m.producer_customer_imp.producer_customer;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static net.mindview.util.Print.print;
/**
 * 经典的生产者消费者的问题
 * 生产者生产出品后，消费者才能消费产品
 * 消费者消费掉产品后，生产者才生产产品
 * <p>
 * 在producer_customer包下
 * 生产者和消费者都在Facotory.product这个对象的等待集合中，
 * 这样做可能会造成一个问题
 * Facotory.product.notifyAll()可能会唤醒不满足条件的线程，浪费资源
 * 所以做如下修改
 * 让生产者线程在生产者对象上等待
 * 让消费者线程在消费者对象上等待
 */


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
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (factory.product != null) {
                        wait();
                    }
                }

                synchronized (factory.customer) {
                    factory.product = new Product();
                    print("生产产品" + factory.product);
                    factory.customer.notifyAll();
                }

            }
        } catch (InterruptedException e) {
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
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (factory.product == null) {
                        wait();
                    }
                }

                synchronized (factory.producer) {
                    print("消费产品" + factory.product);
                    print("-----------------------");
                    factory.product = null;
                    factory.producer.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Factory {
    Product product;
    Producer producer;
    Customer customer;


    public Factory() {
    }
}

public class Classic {


    public static void main(String[] args) throws InterruptedException {
        Factory factory = new Factory();
        Producer producer = new Producer(factory);
        Customer customer = new Customer(factory);
        factory.producer = producer;
        factory.customer = customer;
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producer);
        executorService.execute(customer);
        executorService.shutdown();
        Thread.sleep(5);
        executorService.shutdownNow();
    }
}