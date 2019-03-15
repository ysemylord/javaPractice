package concurrence_m;

import java.util.Timer;
import java.util.TimerTask;

public class EX14_TimerTest {
    public static void main(String[] args) throws InterruptedException {
        int timerCount=100;
        for (int i = 0; i < timerCount; i++) {
          new Timer().schedule(new TimerTask() {
              @Override
              public void run() {
                  System.out.println(Thread.currentThread().getName()+"-"+System.currentTimeMillis());
              }
          },timerCount-i);
        }
        Thread.sleep(timerCount*2);
    }
}
