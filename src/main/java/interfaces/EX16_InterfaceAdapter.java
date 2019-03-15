package interfaces;


import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * 想让CharGenerator类适配到Scanner类
 * 只需要新生成一个类，该类继承CharGenerator实现Readable接口（适配器模式）
 */
public class EX16_InterfaceAdapter {
    public static void main(String[] args) {
        //适配方式一
        CharGeneratorAdapter1 charGeneratorAdapter = new CharGeneratorAdapter1(10);
        Scanner scanner = new Scanner(charGeneratorAdapter);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
            //System.out.println();
        }

        //适配方式二
        CharGeneratorAdapter2 charGeneratorAdapter2=new CharGeneratorAdapter2(new CharGenerator(),10);
        Scanner scanner2 = new Scanner(charGeneratorAdapter2);
        while (scanner2.hasNext()) {
            System.out.println(scanner2.next());
        }

    }
}

/**
 * CharGenerator被适配的类
 */
class CharGenerator {
    private Random random = new Random();

    public String produce() {
        return "" + random.nextInt() + random.nextInt();
    }
}

class CharGeneratorAdapter1 extends CharGenerator implements Readable {

    private int mCount;

    public CharGeneratorAdapter1(int count) {
        mCount = count;
    }

    @Override
    public int read( CharBuffer cb) throws IOException {
        if (mCount-- == 0) {
            return -1;//表示已读完
        }
        String produceCharS = produce();
        cb.append(produceCharS);
        return produceCharS.length();
    }
}

class CharGeneratorAdapter2 implements Readable {
    private CharGenerator mCharGenerator;
    private int mCount;

    public CharGeneratorAdapter2(CharGenerator charGenerator, int count) {
        mCharGenerator = charGenerator;
        mCount = count;
    }

    @Override
    public int read( CharBuffer cb) throws IOException {
        if (mCount-- == 0) {
            return -1;
        }
        String produceStr = mCharGenerator.produce();
        cb.append(produceStr);
        return produceStr.length();
    }
}
