package initAndClear;

/**
 * 创建对象的初始化顺序
 * 1.初始化成员变量
 * 2.执行构造代码块
 * 3.构造器
 */
public class Exercise15 {
    public static void main(String[] args) {
        new Woman();
    }
}

class Woman {
    String name = getName();

    {
        System.out.println("构造代码块");
    }

    public Woman() {
        System.out.println("构造器");
    }
    private String getName(){
        String name = "初始化成员变量";
        System.out.println(name);
        return name;
    }
}