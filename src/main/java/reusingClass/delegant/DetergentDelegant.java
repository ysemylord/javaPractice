package reusingClass.delegant;

/**
 * 代理类
 */
public class DetergentDelegant implements Cleanser {
    private Detergent mDetergent;

    public DetergentDelegant(Detergent detergent) {
        mDetergent = detergent;
    }

    @Override
    public void append(String a) {
        System.out.println("代理先对append做一些操作");
        mDetergent.append(a);
    }

    @Override
    public void scrub() {
        System.out.println("代理先对srub做一些操作");
        mDetergent.scrub();
    }

    @Override
    public void dilute() {
        System.out.println("代理先对dilute做一些操作");
        mDetergent.dilute();
    }
}
