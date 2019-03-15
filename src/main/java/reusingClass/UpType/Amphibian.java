package reusingClass.UpType;

public class Amphibian {
    private String name;

    public Amphibian(String name) {
        this.name = name;
    }
    public void printName(){
        System.out.println(name);
    }
    public void cry(){
        System.out.println(name +"is crying");
    }
}
