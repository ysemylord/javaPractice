package designPattern.adapter;

public class Machine110v {
    /**
     * @param target110v 工作需要110v的电压
     */
    public void work(Target110v target110v) {
        System.out.println("Machine: 接入电压");
        target110v.outPut110v();
        System.out.println("Machine :开始工作");
    }
}
