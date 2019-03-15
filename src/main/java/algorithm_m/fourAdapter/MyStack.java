package algorithm_m.fourAdapter;

import algorithm_m.secondAdapter.MyVector;
import algorithm_m.secondAdapter.VectorDemo;

/**
 * 栈：LIFO
 * 通过扩展Vector来实现栈
 *栈的基本操作
 *
 * push()
 *
 * pop()
 *
 * isEmpty
 *
 * size()
 *
 * 注意：
 * 这里将向量的末尾作为栈顶
 * 是因为这样做插入删除元素的操作时（插入如果不扩容），时间复杂度O（1）
 * 这里将向量的首部作为栈顶
 * 则时间复杂度为O(n)
 *
 */
public class MyStack<T> extends MyVector<T>{
    /**
     * 向栈顶插入元素
     * 即：向向量的末尾处插入元素
     */
    public void push(T e){
        insert(size(),e);
    }

    /**
     * 获取栈顶元素
     * 即：获取末尾元素
     */
    public T top(){
       return (T) get(size()-1);
    }

    /**
     * 删除栈顶元素
     * 即：删除数组的末尾元素
     * @return
     */
    public T pop(){
        return (T) remove(size()-1);
    }
}
