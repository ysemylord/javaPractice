package polymorphism.extension;

public class Exercise10 {
    public static void main(String[] args) {
        Man man=new Baby();
        man.eat();
        /**
         * 结果
         * 就是不洗手
         * 吃饭
         * 原因：
         * java总是使用最底层的对象类型的方法（A继承B，A相对B就是底层）
         * 1.man指向的是Baby的实例，
         * 2.Bady覆盖了Man的wash方法，没有覆盖eat方法
         *
         */
    }
}
class Man{
    public void eat(){
        wash();//吃饭前要洗手
        System.out.println("吃饭");
    }
    public void wash(){
        System.out.println("洗手");
    }
}
class Baby extends Man{
    @Override
    public void wash() {
        System.out.println("就是不洗手");
    }
}