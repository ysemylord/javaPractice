package algorithm_m.secondAdapter;

public class Test {
    public static void main(String[] args) {
        Integer[]  old=new Integer[]{33, 22, 19, 33};
        MyVector myVector=new MyVector(old,0,old.length);
        System.out.println(myVector.toString());
        myVector.bubbleSortB();
        System.out.println(myVector.toString());
    }
}
