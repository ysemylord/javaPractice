package innerClass.ex6UpClass2;

import innerClass.ex6UpClass.Car;

public class CarFactory {
    protected class CarQ5 implements Car{

        //因为CarQ5为protect,所以必须将CarQ5的访问权限设置为public，CarFactoryPlus才能访问CarQ5
        public CarQ5() {
        }

        @Override
        public void name() {
            System.out.println("Car Q5");
        }
    }
}
