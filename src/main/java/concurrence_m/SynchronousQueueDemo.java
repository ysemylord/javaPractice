package concurrence_m;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue=new SynchronousQueue();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("put start");
                    try {
                        synchronousQueue.put(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("put end");
                }
            }).start();

           new Thread(new Runnable() {
               @Override
               public void run() {
                   System.out.println("take start");
                   try {
                       synchronousQueue.take();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("take end");
               }
           }).start();
    }

}
