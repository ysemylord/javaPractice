package designPattern.proxy.staticProxy;

public class Bird implements Flyable{

    @Override
    public void fly()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fly");
    }
}
