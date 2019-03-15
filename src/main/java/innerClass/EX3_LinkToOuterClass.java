package innerClass;

/**
 * 1.内部类可以无障碍地外部类成员变量和成员方法
 *
 */
public class EX3_LinkToOuterClass {

    public static void main(String[] args) {
        Outer3.Inner3 inner3=new Outer3("JACK").getInnerClass();
        System.out.println(inner3);
    }
}

class Outer3 {
    private String name;

    public Outer3(String name) {
        this.name = name;
    }

    class Inner3 {
        @Override
        public String toString() {
            return name;
        }
    }

    public Inner3 getInnerClass() {
        return new Inner3();
    }

}

