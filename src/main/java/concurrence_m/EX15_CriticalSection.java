package concurrence_m;

public class EX15_CriticalSection {
    public static void main(String[] args) {
        testCriticalSectionSync();
       // testCriticalSectionNotSync();

    }

    /**
     * 因为临界区（同步代码块），同步的是同一对象，所以f(),g(),h()是按照顺序进行的
     */
    private static void testCriticalSectionSync() {
        CriticalSectionSync15 criticalSectionSync=new CriticalSectionSync15();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionSync.f();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionSync.g();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionSync.h();
            }
        }).start();
    }

    /**
     * 因为临界区（同步代码块），同步的是同一对象，所以f(),g(),h()不是按照顺序进行的
     */
    private static void testCriticalSectionNotSync() {
        CriticalSectionNotSync15 criticalSectionNotSync=new CriticalSectionNotSync15();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionNotSync.f();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionNotSync.g();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                criticalSectionNotSync.h();
            }
        }).start();
    }


}

class CriticalSectionSync15 {
    public void f() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        }
    }

    public void g() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("g()");
                Thread.yield();

            }
        }
    }

    public void h() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("h()");
                Thread.yield();

            }
        }
    }
}
class CriticalSectionNotSync15 {
    private Object objectG=new Object();
    private Object objectH=new Object();
    public void f() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        }
    }

    public void g() {
        synchronized (objectG) {
            for (int i = 0; i < 10; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    public void h() {
        synchronized (objectH) {
            for (int i = 0; i < 10; i++) {
                System.out.println("h()");
                Thread.yield();
            }
        }
    }
}

