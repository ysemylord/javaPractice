package concurrence_m;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 中断sleep导致的阻塞
 */
public class EX17_interrupt {
    public static void main(String[] args) {
        EX17_Runnabl ex17Runnabl = new EX17_Runnabl(new EX17());
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(ex17Runnabl);
        executorService.shutdown();
        //executorService.shutdownNow();
        future.cancel(true);

    }
}

class EX17 {
    public void s() throws InterruptedException {
        Thread.sleep(4000);

    }
}

    class EX17_Runnabl implements Runnable {
        EX17 ex17;

        public EX17_Runnabl(EX17 ex17) {
            this.ex17 = ex17;
        }

        @Override
        public void run() {
            try {
                ex17.s();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("interrupted here");
            }
        }
    }

