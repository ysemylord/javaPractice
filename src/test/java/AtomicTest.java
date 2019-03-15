import concurrence_m.AotomicDemo;
import org.junit.Test;
import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * i初始为0
 * 期望结果
 * 线程1对进行100次i++,结果为100，
 * 线程2对进行100次i++,结果为100，
 */
public class AtomicTest {



    @Test
    public void test(){
        String url="/content/sing/20190313/2019031317441033076.lrc";

    }

    class MyTest {
        int value = 0;

    }

    /**
     * 没有同步的情况下threa1和thread2交替执行
     *
     * @throws InterruptedException
     */
    @Test
    public void notSynInteger() throws InterruptedException {
        MyTest myTest = new MyTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myTest.value=0;
                for (int i = 0; i < 100; i++) {
                    myTest.value++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + myTest.value);
                }
                System.out.println(myTest.value);
            }

        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myTest.value=0;
                for (int i = 0; i < 100; i++) {
                    myTest.value++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + myTest.value);

                }
                System.out.println(myTest.value);
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();


    }

    /**
     * 使用同步的情况下thread1执行完，再执行thread2
     *
     * @throws InterruptedException
     */
    @Test
    public void synInteger() throws InterruptedException {
        MyTest myTest = new MyTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myTest) {
                    myTest.value=0;
                    for (int i = 0; i < 100; i++) {
                        myTest.value++;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ":" + myTest.value);
                    }
                    System.out.println(myTest.value);
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myTest) {
                    myTest.value=0;
                    for (int i = 0; i < 100; i++) {
                        myTest.value++;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ":" + myTest.value);

                    }
                    System.out.println(myTest.value);
                }
            }
        });
        thread2.start();
        thread1.join();
        thread2.join();

    }

    AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 使用CAS实现的AtomicInteger
     * 线程也会交替执行，
     * 知识保证了内存值与预期值相同
     *
     * @throws Exception
     */
    @Test
    public void atomicInteger() throws Exception {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.set(0);
                for (int i = 0; i < 100; i++) {
                    atomicInteger.incrementAndGet();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
                }
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
            }
        });
        thread1.start();

        Unsafe unsafe= Unsafe.getUnsafe();
        

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.set(0);
                for (int i = 0; i < 100; i++) {
                    atomicInteger.incrementAndGet();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
                }
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());

            }
        });
        thread2.start();

        thread1.join();
        thread2.join();
    }


}
