package reusingClass.UpType;

public class Frog extends Amphibian {
    public Frog(String name) {
        super(name);
    }

    @Override
    public void cry() {
        System.out.println("gua gua");
    }
}
