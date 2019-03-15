package designPattern.singleton;

/**
 * 双重校验锁
 * <p>
 * 双重校验锁是懒汉模式的改进,避免每次都要枷锁判断
 */
public class DoubleLockerSingleton {
    private static DoubleLockerSingleton doubleLockerSingleton;

    private DoubleLockerSingleton() {

    }

    public static DoubleLockerSingleton getInstance() {

        if (doubleLockerSingleton == null) {
            synchronized (DoubleLockerSingleton.class) {
                if(doubleLockerSingleton==null) {
                    doubleLockerSingleton = new DoubleLockerSingleton();
                }
            }
        }
        return doubleLockerSingleton;
    }
}
