package dataStruct;

import java.util.HashMap;

public class EqualsAndHashcode {
    static class Apple {
        String color;

        public Apple(String color) {
            this.color = color;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Apple) {
                Apple apple = (Apple) obj;
                if (this.color.equals(apple.color)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            int result=17;
            result=31*result+color!=null?color.hashCode():0;
            return result;
        }
    }

    public static void main(String[] args) {
        Apple greenApple = new Apple("green");
        HashMap<Apple, Integer> hashMap=new HashMap<>();
        hashMap.put(greenApple,10);
        Apple searchedApple=new Apple("green");
        System.out.println("the number of green greenApple is "+hashMap.get(searchedApple));
    }
}
