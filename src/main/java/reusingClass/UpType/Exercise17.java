package reusingClass.UpType;

public class Exercise17 {
    public static void main(String[] args) {
        Frog frog=new Frog("frog");
        frog.printName();
        frog.cry();
        Amphibian amphibian=frog;
        amphibian.cry();
    }
}
