package eventBus;


public class Test {
    public static void main(String[] args) {

        MySubscriber subscriber=new MySubscriber();
        EventBus.getDefault().register(subscriber);
        MessageEvent event = new MessageEvent();
        event.setName("123");
        EventBus.getDefault().post(event);

        EventBus.getDefault().unregister(subscriber);
        EventBus.getDefault().post(event);

    }
}
