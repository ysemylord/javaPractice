package concurrence_m;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class M_synchronized {

    public static void main(String[] args) {
        DoubleAdd2 doubleAdd=new DoubleAdd2();
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        doubleAdd.addTwo();
                        if (doubleAdd.getNum() % 2 != 0) {
                            System.out.println("出错");
                        }
                    }
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        doubleAdd.addTwo2();
                        if (doubleAdd.getNum() % 2 != 0) {
                            System.out.println("出错");
                        }
                    }
                }
            });
        }
        executorService.shutdown();
    }
}

class DoubleAdd2{
    private int num=0;
    public synchronized void addTwo(){
        num++;
        num++;
    }
    public void addTwo2(){
        synchronized (this) {
            num++;
            num++;
        }
    }
    public synchronized int getNum(){
        return num;
    }
}
