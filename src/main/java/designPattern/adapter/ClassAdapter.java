package designPattern.adapter;

/**
 * 类适配器
 */
public class ClassAdapter extends Adaptee220v implements Target110v {

    @Override
    public int outPut110v() {
        int v220 = this.output220V();
        System.out.println("ClassAdapter :开始将220v电压转化为110v电压");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int v110 = change220VTo110v(v220);
        System.out.println("ClassAdapter :已将220v电压转化为110v电压");
        return v110;
    }

    private int change220VTo110v(int v220) {
        return 110;
    }
}
