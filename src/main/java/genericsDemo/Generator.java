package genericsDemo;

public interface Generator<T> {
    T next(T t);
}
