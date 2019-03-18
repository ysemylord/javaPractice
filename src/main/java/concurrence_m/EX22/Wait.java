package concurrence_m.EX22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Wait {
    private static boolean flag=false;
    public static void main(String[] args) {
        Object object=new Object();
        ExecutorService executorService= Executors.newCachedThreadPool();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                  synchronized (this){
                      try {
                          while (!flag) {
                              System.out.println(Thread.currentThread()+" 当前线程进入Waiting状态");
                              synchronized (object) {
                                  object.wait();
                              }
                              System.out.println(Thread.currentThread()+" 当前线程被唤醒，进入RUNNABLE 状态");
                          }
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      System.out.println("flag 变为 true");
                  }
            }
        };
        executorService.execute(runnable1);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object){
                    flag=true;
                    object.notifyAll();
                }
            }
        });
        executorService.shutdown();
    }
}
