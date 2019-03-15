package designPattern.proxy.staticProxy;

public class BirdLogProxy implements Flyable {
    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly()  {
        System.out.println("start fly");
        flyable.fly();
        System.out.println("end fly");
    }
}
