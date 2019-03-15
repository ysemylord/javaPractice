package concurrence_m.producer_customer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static net.mindview.util.Print.print;

/**
 * 经典的生产者消费者的问题
 * 生产者生产出品后，消费者才能消费产品
 * 消费者消费掉产品后，生产者才生产产品
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
            synchronized (factory) {
                    while (factory.product != null) {
                        factory.wait();
                    }

                    factory.product = new Product();
                    print("生产产品" + factory.product);

                    factory.notifyAll();
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
                synchronized (factory) {
                    while (factory.product == null) {
                        factory.wait();
                    }
                    print("消费产品" + factory.product);
                    print("-----------------------");
                    factory.product = null;
                    factory.notifyAll();
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Factory {
    Product product;


    public Factory() {
    }
}

public class Classic {


    public static void main(String[] args) throws InterruptedException {
        Factory factory = new Factory();
        Producer producer = new Producer(factory);
        Customer customer = new Customer(factory);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producer);
        executorService.execute(customer);
        executorService.shutdown();
        Thread.sleep(1440);
        executorService.shutdownNow();
    }
}