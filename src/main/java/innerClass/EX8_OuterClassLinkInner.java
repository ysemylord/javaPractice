package innerClass;

/**
 * 外部类对象可以访问内部类对象的私有成员
 */
public class EX8_OuterClassLinkInner {
    public static void main(String[] args) {
        new Man().testInner();
    }
}

class Outer8{

    public void test(){
        Inner inner=new Inner();
        String innerName=inner.name;
        inner.print();
    }
    class Inner{
        private String name;
        private void print(){}
    }
}