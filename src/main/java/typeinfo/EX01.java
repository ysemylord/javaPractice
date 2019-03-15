package typeinfo;

/**
 * 使用Class.newInstance()创建对象，Class必须有默认的构造器
 * 不然报异常:InstantiationException
 */

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

interface Beauty{

}

class Toy {
    Toy() {}
    Toy(int i) {
    }
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots,Beauty {
    FancyToy() {
        super(1);
    }
}

public class EX01 {
    static void printInfo(Class<?> cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            return;
        }
        printInfo(c);
        for (Class<?> face : c.getInterfaces())
            printInfo(face);
        Class<?> up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            return;
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            return;
        }
        printInfo(obj.getClass());
    }
}
