package polymorphism.extension;

class Rodent {
    public void hop() {
        System.out.println("Rodent hop");
    }
}

class Mouse extends Rodent {
    @Override
    public void hop() {
        System.out.println("Mouse hop");
    }
}

class Gerbil extends Rodent {
    @Override
    public void hop() {
        System.out.println("Gerbil hop");

    }

}

class Hamster extends Rodent {
    @Override
    public void hop() {
        System.out.println("Hamster hop");

    }

}

public class EX9_Rodent {
    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[]{new Rodent(), new Mouse(), new Gerbil(), new Hamster()};
        for (Rodent rodent : rodents) {
                rodent.hop();
        }
    }
}
