package algorithm_m.leetcode.Minstack155;

import java.util.ArrayList;
import java.util.LinkedList;

public class MinStack {
    class Node{
        int value;
        int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
    private LinkedList<Node> linkedList;

    public MinStack() {
        linkedList = new LinkedList();
    }

    public void push(int x) {

        if(linkedList.size()==0){
            linkedList.addLast(new Node(x,x));
        }else{
            int min1 = getMin();
            int min= min1 <x? min1 :x;
            linkedList.addLast(new Node(x,min));
        }
    }

    public void pop() {
        linkedList.removeLast();
    }

    public int top() {
        return linkedList.peekLast().value;
    }

    public int getMin() {
        return linkedList.peekLast().min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.getMin());
    }
}
