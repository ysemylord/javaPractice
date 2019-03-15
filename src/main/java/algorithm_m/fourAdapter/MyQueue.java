package algorithm_m.fourAdapter;

import java.util.LinkedList;

public class MyQueue<T> extends  LinkedList<T>{



    /**
     * 将元素插入链表尾部
     * 入队列
     * @param e
     */
    public void enQue(T e){
        addLast(e);
    }

    /**
     * 出队列
     * 删除链表首部元素
     * @return
     */
    public T deQue(){
        return removeFirst();
    }

}
