package concurrence_m.EX22;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BusyWait {
    private static boolean flag=false;
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag=true;
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(!flag){
                    System.out.println("flag 为 false");
                }
                flag=false;
                System.out.println("flag 为 true");

            }
        });
        executorService.shutdown();
    }
}
