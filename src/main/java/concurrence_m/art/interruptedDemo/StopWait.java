package concurrence_m.art.interruptedDemo;


public class StopWait {
    public static void main(String[] args) {
        final Object oject = new Object();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (oject) {
                    try {
                        System.out.println(Thread.currentThread() + " 休眠");
                        oject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(Thread.currentThread() + " 被中断");
                    }
                }
            }
        }, "thread1");
        thread1.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (oject) {
                    System.out.println(Thread.currentThread() + " 获得object的锁");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " 失去object的锁");
            }
        }, "thread2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                thread1.interrupt();
            }
        }, "thread3").start();
    }
}
