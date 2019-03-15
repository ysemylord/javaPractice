package interfaces;

import interfaces.interfaceProcessor.Apply;
import interfaces.interfaceProcessor.Processor;

public class Ex11_InterfaceAdapter {
    public static void main(String[] args) {
        StringExchangeAdapter stringExchangeAdapter=new StringExchangeAdapter(new StringExchange());
        Apply.process(stringExchangeAdapter,"12345");
    }
}

/***
 * StringExchange类不可改变；
 * 而要使StringExchange应用于Apply.proccess(Processor,Object)
 * 可以提供一个适配器，该适配器实现Processor，并提供对StringExhange的代理
 * 设计到的知识
 * 1.协变：导出类覆盖的方法的返回类型可以是基类方法返回类型的子类
 * 2.代理模式  StringExchangeAdapter对StringExchange做了一层代理
 * 3.适配模式  StringExchangeAdapter实现Processor，连接了StringExchange和Processor.apply
 */
class StringExchange {
    public String exchange(String string){
        System.out.println("互换字符");
        return string;
    }
}

class StringExchangeAdapter implements Processor{
    private StringExchange mStringExchange;
    public StringExchangeAdapter(StringExchange stringExchange) {
        mStringExchange=stringExchange;
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public String proccess(Object input) {
        return mStringExchange.exchange((String) input);
    }
}