package algorithm_m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigToSmall {
    public static void main(String[] args) {
          bigToSmall(new int[]{1,2,3,4,5,6,3,7,8,9},3);
    }

    private static void bigToSmall(int[] arr, int spanCount){
        System.out.println(Arrays.toString(arr));
        int[] smallArr=null;
        List<int[]> finalList=new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            int col=index%spanCount;//在该列中的位置
            if(col==0){//新的一行
                smallArr=new int[spanCount];
                finalList.add(smallArr);
            }
            smallArr[col]=arr[index];
        }
        for (int i = 0; i < finalList.size(); i++) {
            int[] intArr=finalList.get(i);
            System.out.println(Arrays.toString(intArr));
        }

    }
}
