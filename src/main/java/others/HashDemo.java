package others;

public class HashDemo {
    public static void main(String[] args) {

        int p=-14;
        System.out.println(~p);

        System.out.println(new Integer(100));
        System.out.println(new Integer(100000));

        System.out.println("12345".hashCode());
        System.out.println("12345633".hashCode());

        System.out.println(0xffffffff);
        System.out.println(0x00ffffff);

        System.out.println(~0);
        System.out.println(~(~0));
    }
}
