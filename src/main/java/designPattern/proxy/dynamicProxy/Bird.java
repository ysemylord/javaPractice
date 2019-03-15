package designPattern.proxy.dynamicProxy;

public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public void eat(String food) {
        System.out.println("eat:"+food);
    }
}
