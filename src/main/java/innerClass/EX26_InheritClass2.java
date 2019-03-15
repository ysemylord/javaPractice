package innerClass;

public class EX26_InheritClass2 {
    public static void main(String[] args) {
        WithInner1 withInner1=new WithInner1();

        WithInner2 withInner2=new WithInner2();
        WithInner2.InheritInner inheritInner=withInner2.new InheritInner(withInner1,"123");
    }

}

class WithInner1 {
    class Inner {
        private String name;
        public Inner(String name) {
            this.name=name;
        }
    }
}
class WithInner2{
class InheritInner extends WithInner1.Inner {

    public InheritInner(WithInner1 withInner1, String name) {
        withInner1.super(name);
    }
}
}

