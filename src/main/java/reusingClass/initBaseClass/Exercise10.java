package reusingClass.initBaseClass;

public class Exercise10 {
    public static void main(String[] args) {
         new Stem10("stem");
    }

}

class Component10_1 {
    public Component10_1() {
        System.out.println("component1");
    }
    public Component10_1(String name) {
        System.out.println("component1 "+name);
    }

}

class Compenont10_2 {
    public Compenont10_2() {
        System.out.println("component2");
    }
    public Compenont10_2(String name) {
        System.out.println("component2 "+name);
    }
}

class Compenont10_3 {
    public Compenont10_3() {
        System.out.println("component3");
    }
    public Compenont10_3(String name) {
        System.out.println("component3 "+name);
    }
}

class Root10 {
    Component10_1 compenont1=new Component10_1("1");
    Compenont10_2 compenont2=new Compenont10_2("2");
    Compenont10_3 compenont3=new Compenont10_3("3");

    public Root10() {
        System.out.println("Root");
    }
    public Root10(String name) {
        System.out.println("Root "+name);
    }
}

class Stem10 extends Root10 {
    Component10_1 compenont1=new Component10_1("4");
    Compenont10_2 compenont2=new Compenont10_2("5");
    Compenont10_3 compenont3=new Compenont10_3("6");
    public Stem10() {
        System.out.println("stem");
    }
    public Stem10(String name) {
        System.out.println("stem "+name);
    }
}
