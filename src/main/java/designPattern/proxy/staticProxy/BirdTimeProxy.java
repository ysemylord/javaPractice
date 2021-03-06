package designPattern.proxy.staticProxy;

public class BirdTimeProxy implements Flyable {
    private Flyable flyable;

    public BirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly()  {
        long start = System.currentTimeMillis();
        flyable.fly();
        long end = System.currentTimeMillis();
        System.out.println("flying time is"+ (end - start) / 1000);
    }
}
