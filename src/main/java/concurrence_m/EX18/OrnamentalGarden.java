//: concurrency/OrnamentalGarden.java
package concurrence_m.EX18; /* Added by Eclipse.py */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class Count {
    private int count = 0;
    private Random rand = new Random(47);

    // Remove the synchronized keyword to see counting fail:
    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) // Yield half the time
            Thread.yield();
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}

class Entrance2 implements Runnable {
    private static Count count = new Count();
    private static List<Entrance2> entrances =
            new ArrayList<Entrance2>();
    private int number = 0;
    // Doesn't need synchronization to read:
    private final int id;

    // Atomic operation on a volatile field:
    public static void cancel() {
    }

    public Entrance2(int id) {
        this.id = id;
        // Keep this task in a list. Also prevents
        // garbage collection of dead tasks:
        entrances.add(this);
    }

    public void run() {
        while (true) {
            synchronized (this) {
                ++number;
            }
            print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                print("sleep interrupted");
                break;
            }
        }

        print("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Entrance2 " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance2 entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Entrance2(i));
        // Run for a while, then stop and collect the data:
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            print("Some tasks were not terminated!");
        print("Total: " + Entrance2.getTotalCount());
        print("Sum of Entrances: " + Entrance2.sumEntrances());
    }
} /* Output: (Sample)
Entrance2 0: 1 Total: 1
Entrance2 2: 1 Total: 3
Entrance2 1: 1 Total: 2
Entrance2 4: 1 Total: 5
Entrance2 3: 1 Total: 4
Entrance2 2: 2 Total: 6
Entrance2 4: 2 Total: 7
Entrance2 0: 2 Total: 8
...
Entrance2 3: 29 Total: 143
Entrance2 0: 29 Total: 144
Entrance2 4: 29 Total: 145
Entrance2 2: 30 Total: 147
Entrance2 1: 30 Total: 146
Entrance2 0: 30 Total: 149
Entrance2 3: 30 Total: 148
Entrance2 4: 30 Total: 150
Stopping Entrance2 2: 30
Stopping Entrance2 1: 30
Stopping Entrance2 0: 30
Stopping Entrance2 3: 30
Stopping Entrance2 4: 30
Total: 150
Sum of Entrances: 150
*///:~
