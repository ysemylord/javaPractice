package reusingClass.initBaseClass;

public class Exercise8 {
    public static void main(String[] args) {
         new B8();
         new B8("1");
    }
}

class A8 {
    public A8(String name) {
        System.out.println("A8" + name);
    }
}
class B8 extends A8{
    public B8() {
        super("default");
    }

    public B8(String name) {
        super(name);
    }
}
