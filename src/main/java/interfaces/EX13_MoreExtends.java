package interfaces;


public class EX13_MoreExtends {
    public static void main(String[] args) {
        CombineImpl combine=new CombineImpl();
        combine.f();
    }
}
interface BaseInterface{
    void f();
}

interface CommonInterface1 extends BaseInterface{
    @Override
    void f();
}
interface ConmmonInterface2 extends BaseInterface{
    @Override
    void f();
}

interface CombineInterfceClass  extends CommonInterface1, ConmmonInterface2{
    @Override
    void f();
}
class CombineImpl implements CombineInterfceClass{

    @Override
    public void f() {
        System.out.println("f()");
    }
}
