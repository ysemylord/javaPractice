package innerClass.up6Class6;

import innerClass.ex6UpClass.Car;
import innerClass.ex6UpClass2.CarFactory;

public class CarFactoryPlush extends CarFactory {
    public Car getCarQ5(){
        return new CarQ5();
    }

    public static void main(String[] args) {
        Car car=new CarFactoryPlush().getCarQ5();
        car.name();
    }
}
