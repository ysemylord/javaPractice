package innerClass;

public class EX20_InterfaceNestedClass {
    public static void main(String[] args) {
        Test20.NestedClass20 nestedClass20=new Test20.NestedClass20();
    }
}

class Test20Imp implements Test20{

}
interface Test20{
     class NestedClass20{
        public void print(){
            System.out.println("nest class 20 print");
        }
    }
}
