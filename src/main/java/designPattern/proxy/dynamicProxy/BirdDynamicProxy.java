package designPattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BirdDynamicProxy {

    Flyable flyable;

    public BirdDynamicProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    public Flyable proxy() {
        return (Flyable) Proxy.newProxyInstance(
                flyable.getClass().getClassLoader(),
                flyable.getClass().getInterfaces(),//委托类和代理类的公共接口
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("start");
                        method.invoke(flyable, args);
                        System.out.println("end");
                        return null;
                    }
                });
    }


    public static void main(String[] args) {
        Bird bird = new Bird();
        BirdDynamicProxy birdDynamicProxy = new BirdDynamicProxy(bird);
        Flyable flyableProxy = birdDynamicProxy.proxy();
        flyableProxy.fly();
        flyableProxy.eat("bread");
    }
}
