public class EX8_AccessInnerClass {
}

/**
 * 外部类可以访问内部类的private成员
 */
class A8{
    private B8 b8;
    public A8() {
        b8=new B8();
    }

    public void getB8Name(){
        System.out.println(b8.name);
    }

    class B8{
        private String name;
    }
}