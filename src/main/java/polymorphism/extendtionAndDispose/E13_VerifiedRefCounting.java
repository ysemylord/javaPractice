package polymorphism.extendtionAndDispose;

class Shared {
    private int refcount = 0;
    private static int counter = 0;
    private int id = counter++;

    public Shared() {
        print("Creating " + this);
    }

    public void addRef() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0)
            print("Disposing " + this);
    }

    public String toString() {
        return "Shared " + id;
    }

    private void print(String msg) {
        System.out.println(msg);
    }

    /**
     * 垃圾回收器回收对象前会调用此方法
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(refcount!=0){
            System.out.println("引用计数不为0，不应该清理");
        }else{
            System.out.println("引用计数为0，可以清理");

        }
    }
}

class Composing {
    private Shared shared;
    private static int counter = 0;
    private int id = counter++;

    public Composing(Shared shared) {
        print("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        print("disposing " + this);
        shared.dispose();
    }

    public String toString() {
        return "Composing " + id;
    }

    private void print(String msg) {
        System.out.println(msg);
    }
}

public class E13_VerifiedRefCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {new Composing(shared),
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared)};
        for (Composing c : composing)
            c.dispose();
        System.gc();

        new Composing(new Shared());
        System.gc();

    }
}

