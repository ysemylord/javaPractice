package designPattern.proxy.staticProxy;

public class StaticProxy {
    public static void main(String[] args) {
        Bird bird=new Bird();
        BirdTimeProxy birdTimeProxy=new BirdTimeProxy(bird);
        BirdLogProxy birdLogProxy=new BirdLogProxy(birdTimeProxy);
        birdLogProxy.fly();
    }
}

