package concurrence_m.pratical.blockAndQuenue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用条件的
 * 有界缓存
 *
 * 1.经典的一锁双条件
 * 2.队列的设计
 */
public class ConditionBoundedBuffer {

    public static void main(String[] args) {
        ConditionBoundedBuffer conditionBoundedBuffer=new ConditionBoundedBuffer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int n=1000;
                while(n-->0){
                    try {
                        conditionBoundedBuffer.put(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int n=1000;
                while(n-->0){
                    try {
                        conditionBoundedBuffer.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private int BUFFERED_SIZE = 2;
    private int[] item = new int[BUFFERED_SIZE];
    private int count = 0;
    private int head = 0, tail = 0;
    private Lock lock = new ReentrantLock();
    private Condition not_full = lock.newCondition();
    private Condition not_empty = lock.newCondition();



    /**
     * 插入元素
     *
     * @param num
     * @throws InterruptedException
     */
    public void put(int num) throws InterruptedException {
        lock.lock();
        try {
            while (count >= item.length) {//检察缓存是否已满
                not_full.await();//在not_full上等待
            }
            item[tail++] = num;//插入元素
            if(tail==item.length){
                tail=0;
            }
            count++;
            not_empty.signal();//唤醒在not_empty上等待的线程
            System.out.println("放入元素 还有 "+count);

        } finally {
            lock.unlock();
        }
    }

    /**
     * 插入元素，但是有超时时间
     * @param num
     * @param time
     * @param timeUnit
     * @return
     * @throws InterruptedException
     */
    public boolean offer(int num, long time, TimeUnit timeUnit) throws InterruptedException {
        lock.lock();
        try {
            long nanoWait=timeUnit.toNanos(time);
            while (count >= item.length) {//检察缓存是否已满
                if(nanoWait<=0){
                    return false;
                }
                nanoWait=not_full.awaitNanos(nanoWait);//在not_full上等待
            }
            item[tail++] = num;//插入元素
            if(tail==item.length){
                tail=0;
            }
            count++;
            not_empty.signal();//唤醒在not_empty上等待的线程
            System.out.println("放入元素 还有 "+count);

        } finally {
            lock.unlock();
        }
        return true;
    }



    /**
     * 取出元素
     */

    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {//检察缓存是否为空
                not_empty.await();//在not_empty上等待
            }
            int num=item[head++];
            if(head==item.length){
                head=0;
            }
            count--;
            not_full.signal();
            System.out.println("取出元素 还剩 "+count);
            return num;
        } finally {
            lock.unlock();
        }
    }


    /**
     * 取出元素，有超时时间
     * @param time
     * @param timeUnit
     * @return 队头的元素，如果超时还未取到元素则返回null。
     * @throws InterruptedException
     */
    public Integer poll(long time,TimeUnit timeUnit) throws InterruptedException {
        lock.lock();
        long nanoWait=timeUnit.toNanos(time);
        try {
            while (count == 0) {//检察缓存是否为空
                if(nanoWait<=0){//到达了等待时间
                    return null;
                }
                not_empty.await();//在not_empty上等待
            }
            int num=item[head++];
            if(head==item.length){
                head=0;
            }
            count--;
            not_full.signal();
            System.out.println("取出元素 还剩 "+count);
            return num;
        } finally {
            lock.unlock();
        }
    }
}
