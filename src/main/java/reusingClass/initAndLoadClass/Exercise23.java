package reusingClass.initAndLoadClass;

public class Exercise23 {
    public static void main(String[] args) {
    /*    //创建了两个对象，但是静态构造代码块只执行了一次
        System.out.println("创建第一个实体");
        Test test1=new Test();
        System.out.println("创建第二个实体");
        Test test2=new Test();*/

        //对static方法的调用会引起类的加载
        Test.print();
    }

}

class Test {

    /**
     * 根据静态代码块来判断类是否被加载
     */
    static {
        System.out.println("加载类");
    }

    public static void print() {
        System.out.println("out");
    }
}
