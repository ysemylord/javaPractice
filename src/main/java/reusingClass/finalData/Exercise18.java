package reusingClass.finalData;

import java.util.Random;

public class Exercise18 {

    public static void main(String[] args) {
        FinalData finalData1 = new FinalData();
        FinalData finalData2 = new FinalData();
        //因为value1是static的，所以两个FinalData的value1不一样值一样
        //因为value2是非staic的，所以两个FinalData的value2不一样
        System.out.println(finalData1);
        System.out.println(finalData2);
    }
}

class FinalData {
    static final int value1 = new Random().nextInt();
    final int value2 = new Random().nextInt();

    @Override
    public String toString() {
        return "value1=" + value1 + " " + "value2=" + value2;
    }
}