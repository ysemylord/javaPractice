package innerClass;

/**
 * 必须使用外部类的对象创建内部类的对象
 *
 * <p>
 * 下面这种方法是不行的
 * Outer3.Inner3 inner4=new Outer3.Inner3();
 */
public class EX5_CreatInnerClass {

    public static void main(String[] args) {
        Outer5 outer5 = new Outer5("jack");
        Outer5.Inner5 inner5_1 = outer5.new Inner5();//通过外部类对象创建内部类对象
        Outer5.Inner5 inner5_2 = outer5.new Inner5();
        System.out.println(inner5_1);//inner5_1和inner5_2是两个不同的对象
        System.out.println(inner5_2);//
        inner5_1.getOuterName();//inner5_1与inner5_2关联的是同一个外部类outer5
        inner5_2.getOuterName();
     }
}

class Outer5 {
    private String name;

    public Outer5(String name) {
        this.name = name;
    }

    class Inner5 {
         public void getOuterName(){
             System.out.println(name);
         }
    }

}

