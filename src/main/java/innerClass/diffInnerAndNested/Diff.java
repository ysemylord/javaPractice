package innerClass.diffInnerAndNested;

public class Diff {

    private String name;
    private static String id;

    private void printName() {
        System.out.println(name);
    }

    private static void printId() {
        System.out.println(id);
    }

    class InnerClass {

        //static int age;//3. 内部类不能有静态域，而静态内部类可以有。


        //2. 内部类能透明地访问外围类，静态内部类只能访问外围类的静态域
        private void test() {
            System.out.println(name);
            printName();
            System.out.println(id);
            printId();
        }
    }

    static class NestedClass {
        static int age;       //3. 内部类不能有静态域，而静态内部类可以有。

        //2. 内部类能透明地访问外围类，静态内部类只能访问外围类的静态域
        public void test(){
           // System.out.println(name);
            //printName();
            System.out.println(id);
            printId();
        }
    }

    public static void main(String[] args) {
        Diff diff = new Diff();
        //1. 创建内部类需要外围类的引用，创建静态内部类不需要
        InnerClass innerClass = diff.new InnerClass();
        Diff.NestedClass nestedClass = new Diff.NestedClass();




    }
}
