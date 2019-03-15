package innerClass;

public class EX21_InterfaceNestedClass {
    public static void main(String[] args) {
        Test21.NestedClass21.print(new Test21Imp());
    }
}

class Test21Imp implements Test21 {

    @Override
    public void f() {
        System.out.println("Test21Imp");
    }
}

interface Test21 {
    void f();

    class NestedClass21 {
        static public void print(Test21 test21) {
            test21.f();
        }
    }
}
