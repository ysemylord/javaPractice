package concurrence_m;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EX16_CriticalSection {
    public static void main(String[] args) {
        testCriticalSectionSync();
        //testCriticalSectionNotSync();

    }

    /**
     * 因为临界区（同步代码块），同步的是同一对象，所以f(),g(),h()是按照顺序进行的
     */
    private static void testCriticalSectionSync() {
        CriticalSectionSync16 criticalSectionSync = new CriticalSectionSync16();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionSync.f();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionSync.g();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionSync.h();
            }
        }).start();
    }

    /**
     * 因为临界区（同步代码块），同步的是同一对象，所以f(),g(),h()不是按照顺序进行的
     */
    private static void testCriticalSectionNotSync() {
        CriticalSectionNotSync15 criticalSectionNotSync = new CriticalSectionNotSync15();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionNotSync.f();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionNotSync.g();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionNotSync.h();
            }
        }).start();
    }


}

class CriticalSectionSync16 {
    private Lock lock = new ReentrantLock();

    public void f() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public void g() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("g()");
                Thread.yield();

            }
        } finally {
            lock.unlock();
        }

    }

    public void h() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("h()");
                Thread.yield();

            }
        } finally {
            lock.unlock();
        }

    }
}

class CriticalSectionNotSync16 {
    private Lock lockH = new ReentrantLock();
    private Lock lockG = new ReentrantLock();

    public void f() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        }
    }

    public void g() {
        lockH.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        } finally {
            lockH.unlock();
        }
    }

    public void h() {
        lockG.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("h()");
                Thread.yield();
            }
        } finally {
            lockG.unlock();
        }


    }
}

