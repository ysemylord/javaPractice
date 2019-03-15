package designPattern.singleton;

/**
 * 懒汉模式
 * 在需要时实例化
 */
public class LazySingleton {
    private static LazySingleton lazySingleton ;

    private LazySingleton() {

    }

    public static synchronized LazySingleton getInstance() {
        if(lazySingleton==null){
            lazySingleton=new LazySingleton();
        }
        return lazySingleton;
    }
}
