package algorithm_m.leetcode;

import java.util.LinkedList;

public class Stack<T> extends LinkedList<T> {
    public T top() {
        return peek();
    }

    public void push(T obj) {
        super.push(obj);
    }

    public T pop() {
        return super.pop();
    }
}
