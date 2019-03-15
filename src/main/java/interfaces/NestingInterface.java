package interfaces;

public class NestingInterface {
    public static void main(String[] args) {
        AClass aClass = new AClass();
//        AClass.ImpD2 impD2 = aClass.getD();
//        aClass.getD().print();
        AClass aclass2 = new AClass();
        aclass2.receiveD(aClass.getD());
    }
}

class AClass {
    private interface D {
        public void print();

    }

    private class ImpD implements D {

        @Override
        public void print() {
            System.out.println("ImpD");
        }
    }

    public class ImpD2 implements D {

        @Override
        public void print() {
            System.out.println("ImpD2");
        }
    }

    public D getD() {
        return new ImpD2();
    }

    private D deRef;

    public void receiveD(D d) {
        deRef = d;
        deRef.print();
    }
}