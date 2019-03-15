package reusingClass.initBaseClass;

public class Exercise5 {
    public static void main(String[] args) {
        new C();
    }
}

class A{
    public A() {
        System.out.println("class A constructer");
    }
}

class B{
    public B() {
        System.out.println("class B constructer");
    }
}

class C extends A{
    private B b=new B();
}