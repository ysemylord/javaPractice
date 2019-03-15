//: concurrency/GreenhouseScheduler.java
package concurrence_m.EX33; /* Added by Eclipse.py */
// Rewriting innerclasses/GreenhouseController.java
// to use a ScheduledThreadPoolExecutor.
// {Args: 5000}

import interfaces.ex_controler.Event;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GreenhouseScheduler {
    class TaskDelay implements Runnable, Delayed {

        private Runnable event;
        private long trigger;
        private long period = -1;

        public TaskDelay(long initialDelay, Runnable event) {
            trigger = System.nanoTime() + initialDelay;
            this.event = event;
        }

        public TaskDelay(long initialDelay, long period, Runnable event) {
            this(initialDelay, event);
            this.period = period;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            TaskDelay taskDelay = (TaskDelay) o;
            if (trigger > taskDelay.trigger) {
                return 1;
            }
            if (trigger < taskDelay.trigger) {
                return -1;
            }

            return 0;
        }

        @Override
        public void run() {
            event.run();
        }
    }

    class TaskConsumer implements Runnable {
        private DelayQueue<TaskDelay> mDelayDelayQueue;

        public TaskConsumer(DelayQueue<TaskDelay> mDelayDelayQueue) {
            this.mDelayDelayQueue = mDelayDelayQueue;
        }


        @Override
        public void run() {

            try {
                while (true) {
                    TaskDelay taskDelay = mDelayDelayQueue.take();
                    if (taskDelay.period != -1) {//需要循环执行
                        mDelayDelayQueue.add(new TaskDelay(taskDelay.period, taskDelay.period, taskDelay.event));
                    }
                    taskDelay.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String value) {
        thermostat = value;
    }


    public DelayQueue<TaskDelay> delayedDelayQueue = new DelayQueue<>();

    public void schedule(Runnable event, long delay) {

        TaskDelay taskDelay = new TaskDelay(delay, event);
        delayedDelayQueue.add(taskDelay);
    }

    public void
    repeat(Runnable event, long initialDelay, long period) {


        TaskDelay taskDelay = new TaskDelay(initialDelay, period, event);
        delayedDelayQueue.add(taskDelay);
    }


    class LightOn implements Runnable {
        public void run() {
            // Put hardware control code here to
            // physically turn on the light.
            System.out.println("Turning on lights");
            light = true;
        }
    }

    class LightOff implements Runnable {
        public void run() {
            // Put hardware control code here to
            // physically turn off the light.
            System.out.println("Turning off lights");
            light = false;
        }
    }

    class WaterOn implements Runnable {
        public void run() {
            // Put hardware control code here.
            System.out.println("Turning greenhouse water on");
            water = true;
        }
    }

    class WaterOff implements Runnable {
        public void run() {
            // Put hardware control code here.
            System.out.println("Turning greenhouse water off");
            water = false;
        }
    }

    class ThermostatNight implements Runnable {
        public void run() {
            // Put hardware control code here.
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable {
        public void run() {
            // Put hardware control code here.
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }
    }

    class Bell implements Runnable {
        public void run() {
            System.out.println("Bing!");
        }
    }

    class Terminate implements Runnable {
        public void run() {
            System.out.println("Terminating");
            // Must start a separate task to do this job,
            // since the scheduler has been shut down:
            new Thread() {
                public void run() {
                    for (DataPoint d : data)
                        System.out.println(d);
                }
            }.start();
        }
    }

    // New feature: data collection
    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar d, float temp, float hum) {
            time = d;
            temperature = temp;
            humidity = hum;
        }

        public String toString() {
            return time.getTime() +
                    String.format(
                            " temperature: %1$.1f humidity: %2$.2f",
                            temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    { // Adjust date to the half hour
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(
            new ArrayList<DataPoint>());

    class CollectData implements Runnable {
        public void run() {
            System.out.println("Collecting data");
            synchronized (GreenhouseScheduler.this) {
                // Pretend the interval is longer than it is:
                lastTime.set(Calendar.MINUTE,
                        lastTime.get(Calendar.MINUTE) + 30);
                // One in 5 chances of reversing the direction:
                if (rand.nextInt(5) == 4)
                    tempDirection = -tempDirection;
                // Store previous value:
                lastTemp = lastTemp +
                        tempDirection * (1.0f + rand.nextFloat());
                if (rand.nextInt(5) == 4)
                    humidityDirection = -humidityDirection;
                lastHumidity = lastHumidity +
                        humidityDirection * rand.nextFloat();
                // Calendar must be cloned, otherwise all
                // DataPoints hold references to the same lastTime.
                // For a basic object like Calendar, clone() is OK.
                data.add(new DataPoint((Calendar) lastTime.clone(),
                        lastTemp, lastHumidity));
            }
        }
    }


    public static void main(String[] args) {
        GreenhouseScheduler gh = new GreenhouseScheduler();
        // gh.schedule(gh.new Terminate(), 5000);
        // Former "Restart" class not necessary:
        gh.repeat(gh.new Bell(), 0, 7 * 1000 * 1000);
        gh.repeat(gh.new ThermostatNight(), 0, 2 * 1000 * 1000);
        gh.repeat(gh.new LightOn(), 0, 2 * 1000 * 1000);
        gh.repeat(gh.new LightOff(), 0, 4 * 100 * 1000);
        gh.repeat(gh.new WaterOn(), 0, 6 * 1000 * 1000);
        gh.repeat(gh.new WaterOff(), 0, 8 * 100 * 1000);
        gh.repeat(gh.new ThermostatDay(), 0, 14 * 1000 * 1000);
        //gh.repeat(gh.new CollectData(), 500, 500);

        //new Thread(new TaskConsumor(gh.delayedDelayQueue)).start();
        new Thread(gh.new TaskConsumer(gh.delayedDelayQueue)).start();

    }
} /* (Execute to see output) *///:~
