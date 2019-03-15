package concurrence_m;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 使用标志量控制任务是否停止
 * 传感器记录下收到的信息的数量，并可控制传感器停止
 */
public class EX16_cancel_demo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            executorService.execute(new Sensor(i));
        }
        Thread.sleep(3000);
        Sensor.setCanceled(true);
        executorService.shutdown();
        boolean finished=executorService.awaitTermination(250, TimeUnit.MILLISECONDS);
        if(!finished){
            System.out.println("task is not finished in all ");
        }
        System.out.println("total:"+Sensor.getTotalCount());
        System.out.println("sumSensor:"+Sensor.sumSensor());
    }
}

class SensorCount {
    private int count = 0;

    public synchronized int increment() {
        return count++;
    }

    public synchronized int getCount() {
        return count;
    }

}

class Sensor implements Runnable {
    private int number = 0;
    private int id;
    public static volatile boolean canceled = false;
    public static SensorCount sensorCount = new SensorCount();
    private static List<Sensor> sensorList = new ArrayList<Sensor>();

    public Sensor(int id) {
        this.id = id;
        sensorList.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                number++;
            }
            Thread.yield();
            sensorCount.increment();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized int getNumber() {
        return number;
    }

    public static boolean isCanceled() {
        return canceled;
    }

    public  static void setCanceled(boolean canceled) {
        Sensor.canceled = canceled;
    }

    //因为是在系统停止后调用的，所以可以不用同步
    public static int getTotalCount() {
        return sensorCount.getCount();
    }

    //因为是在系统停止后调用的，所以可以不用同步
    public static int sumSensor() {
        int sum = 0;
        for (Sensor s : sensorList) {
            sum = sum+s.number;
        }
        return sum;
    }
}
