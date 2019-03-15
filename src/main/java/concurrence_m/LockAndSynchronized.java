package concurrence_m;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndSynchronized {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield(); // Cause failure faster
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    synchronized public int produce(){
        ++currentEvenValue;
        Thread.yield(); // Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        LockAndSynchronized lockAndSynchronized=new LockAndSynchronized();
        Runnable runnableLock=(new Runnable() {
            @Override
            public void run() {
                int res=lockAndSynchronized.next()%2;
                while(res==0){

                }
                System.out.println("not event "+res);
            }
        });

       Runnable runnableSynchronized=new Runnable() {
            @Override
            public void run() {
                int res=lockAndSynchronized.produce()%2;
                while(res==0){

                }
                System.out.println("not event "+res);
            }
        };

        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(runnableLock);
        }
        for (int i = 0; i < 10; i++) {
            executorService.execute(runnableSynchronized);
        }
        executorService.shutdown();
    }
}
