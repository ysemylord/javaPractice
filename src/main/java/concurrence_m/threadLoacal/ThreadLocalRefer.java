package concurrence_m.threadLoacal;

public class ThreadLocalRefer {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(LooperRefer.loop());
            }
        });
        thread1.start();
        thread1.join();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(LooperRefer.loop());
            }
        });
        thread2.start();
    }
}

class LooperRefer {
   static int count = 0;





    public static int loop() {
        for (int i = 0; i < 10; i++) {
            count++;
        }
        return count;
    }
}
