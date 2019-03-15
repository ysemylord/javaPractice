package concurrence_m.pratical.designPattern.forth;

import java.util.List;

/**

 **/
public class chainResponsibility {
    public static void main(String[] args) {

    }

}

abstract class Handler {
    //持有下一个处理者。（一个处理者持有一个处理者，其实是一个链表）
    private Handler handler;



    public abstract String handleReuqest(Chain chain);

}

class Request {
    String des;

    public Request(String des) {
        this.des = des;
    }
}

class Chain {

    private Request request;
    private List<Handler> handlers;
    int index;//表明chain当前使用的Hanlder

    public Chain(Request request, List<Handler> handlers, int index) {
        this.request = request;
        this.handlers = handlers;
        this.index = index;
    }

    public Request getRequest() {
        return this.request;
    }

    public String procceed(Request request) {
        Chain chain = new Chain(request, handlers, ++index);
        Handler handler = handlers.get(index);
        return handler.handleReuqest(chain);
    }
}

class ConcreteHandler1 extends Handler {

    @Override
    public String handleReuqest(Chain chain) {
        Request request = chain.getRequest();
        request.des += "\nConcreteHandler1 处理请求\n";
        String res = chain.procceed(request);
        res += "ConcreteHandler1 处理结果";
        return res;
    }
}

class ConcreteHandler2 extends Handler {

    @Override
    public String handleReuqest(Chain  chain) {
        Request request = chain.getRequest();

        request.des += "\nConcreteHandler2 处理请求\n";
        String res = chain.procceed(request);
        res += "ConcreteHandler2 处理结果";
        return res;
    }
}

class FinalHandler2 extends Handler {

    @Override
    public String handleReuqest(Chain  chain) {
        Request request = chain.getRequest();

        request.des += "\nConcreteHandler2 处理请求\n";
        String res = "最终的结果";
        return res;
    }
}
