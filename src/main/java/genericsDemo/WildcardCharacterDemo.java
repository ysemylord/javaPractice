package genericsDemo;

public class WildcardCharacterDemo {
    public void showValue(Generics<Number> generics){
        System.out.println(generics.getValue());
    }

    public void showValueCommen(Generics<?> generics){
        System.out.println(generics.getValue());
    }

    public void showValueImpro(Generics<? extends Number> generics){
        System.out.println(generics.getValue());
    }

    public static void main(String[] args) {
        WildcardCharacterDemo wildcardCharacterDemo=new WildcardCharacterDemo();
        Generics<Number> genericsNumer = new Generics(11);
        Generics<Integer> genericsInt = new Generics(11);
        wildcardCharacterDemo.showValue(genericsNumer);
        //wildcardCharacterDemo.showValue(genericsInt); 泛型

        wildcardCharacterDemo.showValueImpro(genericsNumer);
        wildcardCharacterDemo.showValueImpro(genericsInt);

    }
}
