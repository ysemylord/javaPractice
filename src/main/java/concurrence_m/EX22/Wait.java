package concurrence_m.EX22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Wait {
    private static boolean flag=false;
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                  synchronized (this){
                      try {
                          while (!flag) {
                              wait();
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
                synchronized (runnable1){
                    flag=true;
                    runnable1.notifyAll();
                }
            }
        });
        executorService.shutdown();
    }
}
