package reusingClass.initAndLoadClass;


public class InitOrder {
    public static void main(String[] args) throws InterruptedException {
        Stem stem=new Stem();

    }

}

class Component1 {


    public Component1() {
        System.out.println("初始化基类的成员变量");
    }
}

class Compenont2 {
    public Compenont2() {
        System.out.println("初始化导出类的成员变量");
    }
}


class Root {

    static String name = createRootName();

    private static String createRootName() {
        String name = "root";
        System.out.println("初始化基类的的静态域");
        return name;
    }

    static {
        System.out.println("执行基类的静态构造代码块");
    }


    Component1 compenont1 = new Component1();

    {
        System.out.println("执行基类的构造代码块");
    }

    public Root() {
        System.out.println("执行基类的构造函数主体");
        System.out.println();
    }


}

class Stem extends Root {
    static String name = createRootName();

    private static String createRootName() {
        String name = "stem";
        System.out.println("初始化导出类的的静态域");
        return name;
    }

    static {
        System.out.println("执行导出类的静态构造代码块");
        System.out.println();
    }


    Compenont2 compenont2 = new Compenont2();

    {
        System.out.println("执行导出类类的构造代码块");
    }

    public Stem() {
        System.out.println("执行导出类的构造函数主体");
    }


}
