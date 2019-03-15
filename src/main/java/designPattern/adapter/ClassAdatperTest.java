package designPattern.adapter;

public class ClassAdatperTest {
    public static void main(String[] args) {
        Machine110v machine110v=new Machine110v();
        machine110v.work(new ClassAdapter());
    }
}
