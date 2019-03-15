package interfaces.ex_controler;

import java.util.List;

public class GreenhouseControls extends Controller {
    private boolean light = false;
    private boolean water = false;
    private boolean fan=false;
    private String thermostant = "Day";

    //内部类访问外部类的成员变量
    public class LightOn extends Event {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "light is on";
        }
    }


    public class LightOff extends Event {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "light is off";
        }
    }

    public class WaterOn extends Event {

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "water is on";
        }
    }

    public class WaterOff extends Event {

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "water is off";
        }
    }

    public class ThermostatNight extends Event {

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostant = "Night";
        }

        @Override
        public String toString() {
            return "thermostant on night setting";
        }
    }

    public class ThermostatDay extends Event {

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostant = "Day";
        }

        @Override
        public String toString() {
            return "thermostant on day setting";
        }
    }


    //在action中将一个新的事件插入事件列表

    public class Bell extends Event {

        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Belling!";
        }
    }

    public class Restart extends Event {
        private List<Event> eventList;

        /**
         * 在重启系统的同时，加入event事件
         * @param delayTime
         * @param events
         */
        public Restart(long delayTime, List<Event> events) {
            super(delayTime);
            this.eventList = events;
            for (Event event : eventList) {
                addEvent(event);
            }
        }

        @Override
        public void action() {
            //使系统有规律的重启
            for (Event event : eventList) {
                event.start();
                addEvent(event);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }

    }

    public static class Terminate extends Event {

        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

    public class FanOn extends Event{

        public FanOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan=true;
        }

        @Override
        public String toString() {
            return "FanOn";
        }
    }

    public class FanOff extends Event{

        public FanOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan=false;
        }

        @Override
        public String toString() {
            return "Fan off";
        }
    }



}
