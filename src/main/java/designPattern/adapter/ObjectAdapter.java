package designPattern.adapter;

/**
 * 对象适配器
 */
public class ObjectAdapter implements Target110v {

    private Adaptee220v mAdaptee220v;

    public ObjectAdapter(Adaptee220v adaptee220v) {
        this.mAdaptee220v = adaptee220v;
    }

    @Override
    public int outPut110v()  {
        int v220v=mAdaptee220v.output220V();
        System.out.println("ObjectAdapter：开始将220v电压转化为110v电压");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int v110v=change220VTo110v(v220v);
        System.out.println("ClassAdapter :已将220v电压转化为110v电压");
        return v110v;
    }

    /**
     * 模拟电压转化过程
     * @param v220
     * @return
     */
    private int change220VTo110v(int v220) {
        return 110;
    }
}
