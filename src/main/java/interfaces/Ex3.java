package interfaces;

public class Ex3 {
    public static void main(String[] args) {
       B b=new B();
       b.print();
        /**
         * 结果 null
         * outStr
         * 因为在调用导出类的构造器之前会调用基类的构造方法，
         * 由于动态绑定，基类构造方法中print()绑定的是导出类的print()
         * 而此时outStr=null,所以此时的打印结果是null
         *
         * 总结
         * 不要在构造器中调用方法，这可能会导致意想不到的情况
         */
    }
}

abstract class A {
    abstract void print();
    public A() {
        print();
    }
}

class B extends A{
    public B() {
    }

    String outStr="outStr";
    @Override
    void print() {
        System.out.println(outStr);
    }
}
