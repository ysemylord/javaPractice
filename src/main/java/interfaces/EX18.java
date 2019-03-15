package interfaces;

/**
 * 工厂方法：不同的工厂生产不同的cycle
 */
public class EX18 {
    public static void main(String[] args) {
        Cycles cycles = new Cycles();
        cycles.rideCycle(new UnicycleFactory());
        cycles.rideCycle(new BicycleFactory());
    }
}

class Cycles {

    public void rideCycle(CycleFactory cycleFactory) {
        cycleFactory.getCycle().go();
    }
}

interface Cycle {
    void go();
}

class Unicycle implements Cycle {

    @Override
    public void go() {
        System.out.println(" UniCylce go");
    }
}

class Bicycle implements Cycle {

    @Override
    public void go() {
        System.out.println("Bicycle go");
    }
}

interface CycleFactory {
    Cycle getCycle();
}

class UnicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}