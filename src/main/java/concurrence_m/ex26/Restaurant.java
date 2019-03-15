//: concurrency/Restaurant.java
package concurrence_m.ex26; /* Added by Eclipse.py */
// The producer-consumer approach to task cooperation.

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * WaitPerson上菜后通知BusBoy清理，
 * BusBoy清理完成后WaitPersion才能上菜
 */
class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}


class BusBoy implements Runnable {
    private Restaurant restaurant;
    public volatile boolean notified=false;
    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {

            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (!notified) {
                        wait();
                    }
                    notified=false;
                }
                print("busboy clear");
                synchronized (restaurant.waitPerson){
                    restaurant.waitPerson.notified=true;
                    restaurant.waitPerson.notifyAll();
                }
            }
        }catch (InterruptedException in) {
            print("BusBoy interrupted");
        }
    }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;
    public boolean notified=false;

    public WaitPerson(Restaurant r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null)
                        wait(); // ... for the chef to produce a meal
                }
                print("Waitperson got " + restaurant.meal);


                synchronized (restaurant.busBoy){
                    restaurant.busBoy.notified=true;
                    restaurant.busBoy.notifyAll();
                }

                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // Ready for another
                }
                synchronized (this){
                    while(!notified){
                        wait();//等待BusBoy清理
                    }
                    notified=false;
                }



            }
        } catch (InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait(); // ... for the meal to be taken
                }
                if (++count == 10) {
                    print("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                printnb("Order up! ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}


public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    BusBoy busBoy=new BusBoy(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
} /* Output:
Order up! Waitperson got Meal 1
Order up! Waitperson got Meal 2
Order up! Waitperson got Meal 3
Order up! Waitperson got Meal 4
Order up! Waitperson got Meal 5
Order up! Waitperson got Meal 6
Order up! Waitperson got Meal 7
Order up! Waitperson got Meal 8
Order up! Waitperson got Meal 9
Out of food, closing
WaitPerson interrupted
Order up! Chef interrupted
*///:~
