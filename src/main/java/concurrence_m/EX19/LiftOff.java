//: concurrency/LiftOff.java
package concurrence_m.EX19; /* Added by Eclipse.py */
// Demonstration of the Runnable interface.

public class LiftOff implements Runnable {
  protected int countDown = 10; // Default
  private static int taskCount = 0;
  private final int id = taskCount++;
  public LiftOff() {}
  public LiftOff(int countDown) {
    this.countDown = countDown;
  }
  public String status() {

    return "#" + id + "(" +
      (countDown > 0 ? countDown : "Liftoff!") + "), ";
  }
  public void run() {
    while(countDown-- > 0) {
      if(Thread.currentThread().isInterrupted()){
        System.out.println(id+"is by interupted");
        return;
      }
      System.out.print(status());
      Thread.yield();
    }
  }
} ///:~
