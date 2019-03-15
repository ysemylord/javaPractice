package polymorphism.extendtionAndDispose;


class ShareHouse {
    static int ref=0;
    public void addRe(){
        ref++;
    }
    public void dispose(){
        ref--;
        if(ref==0){
            System.out.println("dispose house");
        }
    }
}

class Rodent {
    ShareHouse house;
    public Rodent(ShareHouse house) {
        this.house=house;
        house.addRe();
    }

    public void hop() {
        System.out.println("Rodent hop");
    }
    public void dispose(){
        System.out.println("dispose "+getClass().getSimpleName());
        house.dispose();
    }
}

class Mouse extends Rodent {
    public Mouse(ShareHouse house) {
        super(house);
    }

    @Override
    public void hop() {
        System.out.println("Mouse hop");
    }
}

class Gerbil extends Rodent {
    public Gerbil(ShareHouse house) {
        super(house);
    }

    @Override
    public void hop() {
        System.out.println("Gerbil hop");

    }


}

class Hamster extends Rodent {
    public Hamster(ShareHouse house) {
        super(house);
    }

    @Override
    public void hop() {
        System.out.println("Hamster hop");

    }


}

public class EX14_Rodent {
    public static void main(String[] args) {
        ShareHouse house=new ShareHouse();
        Rodent[] rodents = new Rodent[]{new Rodent(house), new Mouse(house), new Gerbil(house), new Hamster(house)};
        for (Rodent rodent : rodents) {
                rodent.dispose();
        }
    }
}
