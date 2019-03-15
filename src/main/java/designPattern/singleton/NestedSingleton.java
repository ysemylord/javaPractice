package designPattern.singleton;

/**
 * 静态内部内实现
 */
public class NestedSingleton {
    private static NestedSingleton nestedSingleton;

    private NestedSingleton() {

    }

    private static class SingleHolder {
        static NestedSingleton nestedSingleton = new NestedSingleton();
    }

    public static synchronized NestedSingleton getInstance() {
        return SingleHolder.nestedSingleton;
    }
}
