package concurrence_m;

import java.util.concurrent.atomic.AtomicInteger;

public class AotomicDemo {
    static class MyTest{
        int value=0;

    }

    public static void main(String[] args) {
        //testAtomic();
        MyTest myTest=new MyTest();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (myTest) {
                        for (int i = 0; i < 100; i++) {
                            myTest.value++;
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName()+":"+myTest.value);
                        }
                        System.out.println(myTest.value);
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (myTest) {
                        for (int i = 0; i < 100; i++) {
                            myTest.value++;
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName()+":"+myTest.value);

                        }
                        System.out.println(myTest.value);
                    }
                }
            }).start();

    }

    private static void testAtomic() {
        AtomicInteger atomicInteger =new AtomicInteger();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++) {
                    atomicInteger.incrementAndGet();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(atomicInteger.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++) {
                    atomicInteger.incrementAndGet();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(atomicInteger.get());
            }
        }).start();
    }
}
