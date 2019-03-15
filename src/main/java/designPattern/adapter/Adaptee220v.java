package designPattern.adapter;

/**
 * 被适配者 220v电压
 */
public class Adaptee220v {
    public int output220V(){
        System.out.println("Adaptee220v:输出220v电压的准备工作");
        try {
            //模拟准备工作耗时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Adaptee220v:准备完毕，输出220v电压");
        return 220;
    }
}
