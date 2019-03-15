package others;

import java.util.ArrayList;

public class KKK {

    public static void main(String[] args) {
       ArrayList<Integer> arr=new ArrayList<>();
       arr.add(0);
       arr.add(1);
       arr.add(2);
       arr.add(3);
       for (int i=0;i<arr.size();i++){
           arr.remove(new Integer(1));
           System.out.println(arr.get(i));
       }

        for (Integer num :arr) {
            arr.remove(num);
            arr.add(new Integer(100));
            System.out.println(num);
        }

    }

    private static void do1(StringBuilder stringBuilder){
        stringBuilder.append("222");
        System.out.println();
    }

    private static void do2(StringBuilder stringBuilder){
        stringBuilder=new StringBuilder("22222");
        System.out.println();
    }
}
