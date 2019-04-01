package concurrence_m;

import java.util.concurrent.locks.ReentrantLock;

public class ReetrenLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock=new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

        Thread.sleep(2000);

       // thread2.interrupt();


    }
}
