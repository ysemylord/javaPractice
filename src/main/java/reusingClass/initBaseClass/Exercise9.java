package reusingClass.initBaseClass;

public class Exercise9 {
    public static void main(String[] args) {
        new Stem();
    }

}

class Component1 {
    public Component1() {
        System.out.println("component1");
    }
}

class Compenont2 {
    public Compenont2() {
        System.out.println("component2");
    }
}


class Root {
    static String rootStr=initRoot();
    Component1 compenont1 = new Component1();

    public Root() {
        System.out.println("Root");
    }

    private static String initRoot(){
        String s = "init rootStr";
        System.out.println(s);
        return s;
    };

}

class Stem extends Root {
    static String stemStr=initStem();

    private static String initStem() {
        String initStem = "init stemStr";
        System.out.println(initStem);
        return initStem;
    }

    Compenont2 compenont2 = new Compenont2();

    public Stem() {
        System.out.println("stem");
    }

    public Stem(String name) {
        System.out.println("stem " + name);
    }
}
