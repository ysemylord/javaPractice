package reusingClass.initBaseClass;

public class Exercise7 {
    public static void main(String[] args) {
        C c=new C("c");
    }
    static class A{
        public A(String a) {
            System.out.println("class A constructer "+a);
        }
    }

    static class B{
        public B(String b) {
            System.out.println("class B constructer "+b);
        }
    }

     static class C extends A {
        public C(String c) {
            super( c);
            B b=new B("b");
            System.out.println("class A constructer "+c);
        }
    }
}

