package concurrence_m;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Ex21_wait_notify {

    public static void main(String[] args) {

        ExecutorService executorService=Executors.newCachedThreadPool();

        Runable1 runable1 = new Runable1();
        executorService.execute(runable1);
        executorService.execute(new Runable2(runable1));
        executorService.shutdown();
    }
}


class Runable1 implements Runnable{


    @Override
    public void run() {

       synchronized (this){
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        System.out.println("等待结束");

    }
}

class Runable2 implements Runnable{

    private final Runable1 runable1;

    public Runable2(Runable1 runable1) {
        this.runable1 = runable1;
    }

    @Override
    public void run() {
        Thread.yield();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (runable1){
            runable1.notifyAll();
        }
    }
}