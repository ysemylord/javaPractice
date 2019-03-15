package concurrence_m.pratical.designPattern;

/**
 * 一个标准的责任连模式
 */
public class chainResponsibility {
    public static void main(String[] args) {
        ConcreteHandler1 concreteHandler1=new ConcreteHandler1();
        ConcreteHandler2 concreteHandler2=new ConcreteHandler2();
        concreteHandler1.setHandler(concreteHandler2);
        System.out.println( concreteHandler1.handleReuqest(new Request(1)));
        System.out.println( concreteHandler1.handleReuqest(new Request(6)));
        System.out.println( concreteHandler1.handleReuqest(new Request(111)));
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
    int numm;

    public Request(int numm) {
        this.numm = numm;
    }
}

class ConcreteHandler1 extends Handler{

    @Override
    public String handleReuqest(Request request) {
        //能处理则处理，不能处理则交给后继处理
        if(request.numm<3){
            return "ConcreteHandler1 处理";
        }else{
            Handler handler = getHandler();
            if(handler!=null) {
               return handler.handleReuqest(request);
            }
            return "没人处理";
        }
    }
}

class ConcreteHandler2 extends Handler{

    @Override
    public String handleReuqest(Request request) {
        if(request.numm<10){
            return "ConcreteHandler2 处理";

        }else{
            Handler handler = getHandler();
            if(handler!=null) {
              return  handler.handleReuqest(request);
            }
            return "没人处理";

        }
    }
}
