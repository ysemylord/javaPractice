package algorithm_m.fourAdapter;

import algorithm_m.fourAdapter.MyStack;

public class StackTest {
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        System.out.println(myStack.pop());
        myStack.push(2);
        System.out.println(myStack.pop());
    }
}
