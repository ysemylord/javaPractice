package eventBus;

public class MySubscriber {
    @Subscribe
    public void onEvent(MessageEvent messageEvent){
        System.out.println("收到消息:"+messageEvent.name);
    }

}
