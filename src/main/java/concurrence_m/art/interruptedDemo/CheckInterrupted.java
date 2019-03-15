package concurrence_m.art.interruptedDemo;

/**
 * 检查中断的形式停止线程
 */
public class CheckInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread countTread = new Thread(new CountRunable());
        countTread.start();
        Thread.sleep(2000);
        countTread.interrupt();
    }

    private static class CountRunable implements Runnable {
        private int count = 0;

        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("检查到中断");
                    break;
                }
                System.out.println("now count is " + count++);
            }
        }
    }
}

