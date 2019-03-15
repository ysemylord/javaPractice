package concurrence_m.art.wait;

import net.mindview.simple.List;

public class WaitDemo {

    private static Object lock=new Object();
    private static int count=0;

    public static void main(String[] args) {
        Thread waitThread=new Thread(new WaitRunable());
        waitThread.start();
        Thread notifyThread=new Thread(new NotifyRunable());
        notifyThread.start();
    }

    private static class WaitRunable implements Runnable {

        @Override
        public void run() {
            synchronized (lock){
                System.out.println("Wait 获取到锁");
                while(count!=100){
                    try {
                        System.out.println("Wait 调用wait()方法,释放锁，进入WAITING状态，进入lock的等待队列");
                        lock.wait();//线程释放锁，进入WAITING状态，进入lock的等待队列
                        System.out.println("Wait 获取到锁 从wait()中返回");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class NotifyRunable implements Runnable {

        @Override
        public void run() {
              synchronized (lock){
                  System.out.println("Notify获取到锁");

                  System.out.println("Notify通知WAIT，由WAITING状态进入BLOCKED状态");
                  lock.notify();
                  try {
                      Thread.sleep(2000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  count=100;
                  System.out.println("Notifye运行结束");
              }
              synchronized (lock){
                  System.out.println("Notify再次获取到锁");
                  try {
                      Thread.sleep(2000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

              }
        }
    }
}
