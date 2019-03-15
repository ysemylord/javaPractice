package genericsDemo;

public class Test {
    public static void main(String[] args) {
        Generics<String > generics=new Generics();
        generics.setValue("字符串");
        //generics.setValue(222); 报错
    }
}
