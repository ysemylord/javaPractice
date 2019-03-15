package designPattern.adapter;

public class ObjectAdatperTest {
    public static void main(String[] args) {
        Machine110v machine110v=new Machine110v();
        Adaptee220v adaptee220v = new Adaptee220v();
        ObjectAdapter target110v = new ObjectAdapter(adaptee220v);
        machine110v.work(target110v);
    }
}
