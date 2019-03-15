package reusingClass.delegant;

/**
 * 真实主题
 */
public class Detergent implements Cleanser {
    private String a = "";

    public Detergent(String a) {
        this.a = a;
    }

    @Override
    public void append(String a) {
        this.a += a;
        System.out.println("detergent append");
    }

    @Override
    public void scrub() {
        a += "scrub";
        System.out.println("detergent scrub");

    }

    @Override
    public void dilute() {
        a += "dilute";
        System.out.println("detergent dilute");

    }

}
