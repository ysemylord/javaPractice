package interfaces.ex_controler;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (Event event : new ArrayList<Event>(eventList)) {//ConcurrentModificationException
                if (event.ready()) {
                    System.out.println(event.toString());
                    event.action();
                    eventList.remove(event);
                }
            }
        }
        System.out.println("控制器结束");
    }

    public static void main(String[] args) {
        Controller controller=new Controller();
        controller.addEvent(new Event(1000) {
            @Override
            public void action() {
                System.out.println("事件一");
            }
        });
        controller.addEvent(new Event(1000) {
            @Override
            public void action() {
                System.out.println("事件二");
            }
        });
        controller.run();
    }
}
