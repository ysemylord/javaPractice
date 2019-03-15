package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    private static EventBus mEventBus;
    //事件与订阅者的对应
    private Map<Class<?>, List<Subscription>> subscriptionsByEventType = new HashMap<>();

    //订阅者与其订阅事件的映射
    private Map<Object, List<Class<?>>> eventTypeClazzBySubscription = new HashMap<>();

    public static EventBus getDefault() {
        if (mEventBus == null) {
            synchronized (EventBus.class) {
                if (mEventBus == null) {
                    mEventBus = new EventBus();
                }
            }
        }
        return mEventBus;
    }

    public void register(Object subscriber) {
        Class classzz = subscriber.getClass();
        Method[] methods = classzz.getDeclaredMethods();
        for (Method method : methods) {

            Class<?>[] eventType = method.getParameterTypes();
            if (eventType.length == 1) {
                Subscribe subscribe = method.getAnnotation(Subscribe.class);
                if (subscribe != null) {//是我们定义的注解
                    Class<?> eventTypeClass = eventType[0];
                    ThreadMode threadMode = subscribe.threadMode();
                    Subscription subscription = new Subscription(subscriber, method, threadMode, eventTypeClass);

                    ///
                    List<Subscription> subscriptionList = subscriptionsByEventType.get(subscribe);
                    if (subscriptionList == null) {
                        subscriptionList = new ArrayList<>();
                    }
                    if (!subscriptionList.contains(subscription)) {
                        subscriptionList.add(subscription);
                    }
                    subscriptionsByEventType.put(eventTypeClass, subscriptionList);

                    //
                    List<Class<?>> events = eventTypeClazzBySubscription.get(subscription);
                    if (events == null) {
                        events = new ArrayList<>();
                    }
                    events.add(eventTypeClass);
                    eventTypeClazzBySubscription.put(subscriber, events);

                    System.out.println(eventTypeClass.getName());
                }
            }
        }
    }

    public void unregister(Object subscriber) {
        List<Class<?>> eventTypeClazzs = eventTypeClazzBySubscription.get(subscriber);
        int size = eventTypeClazzs.size();
        for (int i = 0; i < size; i++) {
            Class<?> eventTypeClazz = eventTypeClazzs.get(i);
            List<Subscription> subscriptions = subscriptionsByEventType.get(eventTypeClazz);
            subscriptions.remove(i);
            i--;
            size--;
        }

        eventTypeClazzBySubscription.remove(subscriber);

    }

    public void post(Object event) {
        Class eventTypeClass = event.getClass();
        List<Subscription> subscriptions = subscriptionsByEventType.get(eventTypeClass);
        for (Subscription subscription : subscriptions) {
            try {
                subscription.method.invoke(subscription.subscriber,event);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    class Subscription {
        final Object subscriber;
        final Method method;
        final ThreadMode threadMode;
        final Class eventType;

        public Subscription(Object subscriber, Method method, ThreadMode threadMode, Class eventType) {
            this.subscriber = subscriber;
            this.method = method;
            this.threadMode = threadMode;
            this.eventType = eventType;
        }


    }
}
