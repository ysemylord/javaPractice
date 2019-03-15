package initAndClear;

/**
 * 加载类后，进行静态初始化
 * 静态初始化的执行顺序
 * 1.先初始化静态域
 * 2.执行静态代码块
 */
public class Exercise14 {
    public static void main(String[] args) {
        Man.print();
    }
}
class Man{
    static String id;
    static String name=getName();
    static {
        System.out.println("执行静态代码块");
        id="122";
    }
    static String getName(){
        System.out.println("执行 getName");
        return "jack";
    }
    static void print(){
        System.out.println("print name="+name);
        System.out.println("print id="+id);
    }
}
