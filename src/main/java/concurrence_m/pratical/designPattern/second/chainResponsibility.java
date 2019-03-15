package concurrence_m.pratical.designPattern.second;

/**
 * 模仿Okhttp的责任链 1
 * 1.Handler自己先处理Request然后交给后继继续处理，直到没有后继。
 */
public class chainResponsibility {
    public static void main(String[] args) {
        ConcreteHandler1 concreteHandler1=new ConcreteHandler1();
        ConcreteHandler2 concreteHandler2=new ConcreteHandler2();
        concreteHandler1.setHandler(concreteHandler2);
        System.out.println( concreteHandler1.handleReuqest(new Request("开始")));
    }

}

abstract class Handler{
    //持有下一个处理者。（一个处理者持有一个处理者，其实是一个链表）
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public abstract String handleReuqest(Request request);

}

class Request{
    String des;

    public Request(String des) {
        this.des = des;
    }
}

class ConcreteHandler1 extends Handler {

    @Override
    public String handleReuqest(Request request) {
        request.des+="\nConcreteHandler1 处理\n";
        Handler handler = getHandler();
        if(handler==null) {
            return request.des;
        }
        return  handler.handleReuqest(request);
    }
}

class ConcreteHandler2 extends Handler {

    @Override
    public String handleReuqest(Request request) {
        request.des+="\nConcreteHandler2 处理\n";
        Handler handler = getHandler();
        if(handler==null) {
            return request.des;
        }
        return  handler.handleReuqest(request);
    }
}
