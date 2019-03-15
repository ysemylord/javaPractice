package genericsDemo;

import java.util.Random;

/**
 * 实现泛型接口时，指定泛型类型
 */
public class FruitGenerator2 implements Generator<String>{

    private Random random=new Random();

    @Override
    public String next(String s) {
        return random.nextInt()+s;
    }

    public static void main(String[] args) {
        FruitGenerator2 fruitGenerator2=new FruitGenerator2();
        fruitGenerator2.next("f");
    }


}
