package interfaces.interfaceProcessor;

public class Apply {
    /**
     * 策略模式
     * @param processor 处理器
     * @param object 要处理的对象
     */
    public static void process(Processor processor, Object object){
        System.out.println("using processor"+processor.name());
        processor.proccess(object);
    }
}
