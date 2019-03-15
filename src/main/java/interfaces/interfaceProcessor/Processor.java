package interfaces.interfaceProcessor;

/**
 * 抽象的处理器类
 */
public interface Processor {
    String name();
    Object proccess(Object input);
}
