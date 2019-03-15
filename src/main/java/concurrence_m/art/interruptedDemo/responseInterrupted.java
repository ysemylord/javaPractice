package concurrence_m.art.interruptedDemo;

/**
 * 响应中断异常的方式停止线程
 */
public class responseInterrupted {

    public static void main(String[] args) {
        Thread seepThread=new Thread(new SleepRunable());
        seepThread.start();
        seepThread.interrupt();
    }

    private static class SleepRunable implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("抛出中断异常，线程停止");
            }
        }
    }
}
