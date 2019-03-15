package concurrence_m.art.JionDemo;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main 线程开始执行");
        Thread join=new Thread(new JoinRunable(),"JoinThread");
        join.start();
        join.join();
        System.out.println("main 线程执行结束");
    }

    private static class JoinRunable implements Runnable{

        @Override
        public void run() {
            String threadName=Thread.currentThread().getName();
            System.out.println(threadName+"开始执行");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName+"执行结束");

        }
    }
}
