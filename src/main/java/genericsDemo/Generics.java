package genericsDemo;

/**
 * 泛型类
 *
 * @param <T>
 */
public class Generics<T> {

    public Generics() {
    }

    public Generics(T value) {
        this.value = value;
    }

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
