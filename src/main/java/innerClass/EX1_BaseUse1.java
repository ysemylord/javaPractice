package innerClass;

public class EX1_BaseUse1 {
    Outer.Inner inner = new Outer().getInnerClass();

    public static void main(String[] args) {

    }
}

class Outer {
    class Inner {

    }

    public Inner getInnerClass() {
        return new Inner();
    }

}

