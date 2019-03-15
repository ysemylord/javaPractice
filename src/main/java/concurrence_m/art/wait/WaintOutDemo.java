package concurrence_m.art.wait;

public class WaintOutDemo {
    private static Object lock = new Object();
    private static int count = 0;
    private static Thread waitThread;

    public static void main(String[] args) {
        waitThread = new Thread(new WaintOutDemo.WaitRunable());
        waitThread.start();
        Thread notifyThread = new Thread(new OtherRunable());
        notifyThread.start();
    }

    private static class WaitRunable implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("Wait 获取到锁");
                while (count != 100) {
                    try {
                        System.out.println("Wait 调用wait(timeout)方法,释放锁，进入WAITING状态，进入lock的等待队列");
                        lock.wait(1000);//线程释放锁，进入WAITING状态，进入lock的等待队列
                                               //OtherThead向WaitThread发起中断，此时WaitThrea由WAITGING状态进入BLOCKE状态
                                               //OtherThead如果想从wait返回，必须等OtherThead释放掉锁只有，OtherThead获取到锁
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                        System.out.println("Wait 中断");
                    }

                    System.out.println("Wait 获取到锁 从wait(timeout)中返回");
                }
            }
        }
    }

    private static class OtherRunable implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("Other获取到锁");
                System.out.println("Other 向 Wait 发出中断");
                waitThread.interrupt();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count = 100;
                System.out.println("Other运行结束,释放锁");
            }
        }
    }
}
