package concurrence_m.art.interruptedDemo;

public class StopSleep {
    public static void main(String[] args) {
        //thread1一直等待
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("thread1 被中断");
                }
            }
        });
        thread1.start();
        thread1.interrupt();
    }
}
