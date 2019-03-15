package innerClass;

/**
 * 内部类对象可以完整的访问外部类的对象，即使是private成员
 */
public class EX7_LinkToOuterClass {
    public static void main(String[] args) {
        new Man().testInner();
    }
}

class Man{
    private String name;
    private void print(){
        System.out.println(name);
    }
    public void testInner(){
        Inner inner=new Inner();
        inner.modifyManName("jhon");
    }
    class Inner{
        void modifyManName(String name){
            Man.this.name=name;
            print();
        }
    }
}