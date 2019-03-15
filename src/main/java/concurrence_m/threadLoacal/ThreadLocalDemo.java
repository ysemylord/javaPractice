package concurrence_m.threadLoacal;

public class ThreadLocalDemo {

    /**
     * 因为使用了线程本地变量，每个线程都要自己的threadLocalp变量，
     * 所以
     * thread1的输出为10，
     * thread2的输出也为10.
     * 如果不是线程本地变量，则
     * thread1的输出为10，
     * thread2的输出也为20.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                System.out.println(Looper.loop());
            }
        });
        thread1.start();
        thread1.join();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                System.out.println(Looper.loop());
            }
        });
        thread2.start();
    }
}

class Looper {
    int count = 0;
    static ThreadLocal<Looper> threadLocalp;

    /**
     * 在线程中调用prepare创建本线程的threadLocal
     * 并设置值
     */
    public static void prepare() {
        threadLocalp = new ThreadLocal<>();
        threadLocalp.set(new Looper());
    }

    public static ThreadLocal<Looper> getLooper() {
        return threadLocalp;
    }


    public static int loop() {
        Looper looper = getLooper().get();//获取到线程本地变量的值
        for (int i = 0; i < 10; i++) {
            looper.count++;
        }
        return looper.count;
    }
}
