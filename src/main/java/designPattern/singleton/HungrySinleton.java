package designPattern.singleton;

/**
 * 饿汉模式
 * 在类加载时，实例化
 */
public class HungrySinleton {
    private static HungrySinleton hungrySinleton = new HungrySinleton();

    private HungrySinleton() {

    }

    public static HungrySinleton getInstance() {
        return hungrySinleton;
    }
}
