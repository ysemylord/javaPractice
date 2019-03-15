package concurrence_m.componentDemo;

import java.util.concurrent.*;

public class DelayQuenueDemo {
    public static void main(String[] args) {
        DelayQueue<DelayTask> delayTasks=new DelayQueue<>();
        delayTasks.add(new DelayTask(5*1000*1000));
        delayTasks.add(new DelayTask(1*1000*1000));
        delayTasks.add(new DelayTask(3*1000*1000));
        ExecutorService executorService= Executors.newCachedThreadPool();
        delayTasks.add(new EndTask(6*1000*1000,executorService));
        executorService.execute(new TaskConsumer(delayTasks));

        executorService.shutdown();

    }

}
class TaskConsumer implements Runnable{
    DelayQueue<DelayTask> delayTasks;

    public TaskConsumer(DelayQueue<DelayTask> delayTasks) {
        this.delayTasks = delayTasks;
    }

    @Override
    public void run() {
        try {
            while(true) {
                delayTasks.take().doThing();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class EndTask extends DelayTask {
    private ExecutorService executorService;
    public EndTask(long delayNano,ExecutorService executorService) {
        super(delayNano);
        this.executorService=executorService;
    }

    @Override
    public void doThing(){
        System.out.println("中断消费者线程，避免一直等待");
         executorService.shutdownNow();
    }
}
class DelayTask implements Delayed{

    private static int count;
    private int id;
    public long trigger;

    public DelayTask(long delayNano) {
        this.id = count++;
        trigger=System.nanoTime()+delayNano;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger-System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    /**
     * 大的值排在队列后面，小的值排在队列前面
     * @param delayed
     * @return
     */
    @Override
    public int compareTo(Delayed delayed) {
        DelayTask thatDelay= (DelayTask) delayed;
        if(trigger>thatDelay.trigger){return  1;}
        else if(trigger<thatDelay.trigger){return -1;}
        return 0;
    }

    public void doThing(){
        System.out.println("第"+id+"号任务开始，在"+trigger+"触发");
    }


}