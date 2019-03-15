package genericsDemo;

/**
 * 实现泛型接口时，不指定泛型类型
 */
public class FruitGenerator1<T> implements Generator<T> {
    @Override
    public T next(T s) {
        return null;
    }

    public static void main(String[] args) {
        FruitGenerator1<String> fruitGenerator1=new FruitGenerator1();
        fruitGenerator1.next("33");
    }
}
