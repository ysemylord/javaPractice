package concurrence_m.art.JionDemo;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread joinThread = new Thread(new JoinRunable(), "JoinThread");
        joinThread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " 线程开始执行");
                try {
                    joinThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + " 线程执行结束");

            }
        }, "thread 2");
        thread2.start();

    }

    private static class JoinRunable implements Runnable {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "开始执行");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + "执行结束");

        }
    }
}
