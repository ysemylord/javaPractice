package algorithm_m;

import java.util.Arrays;

public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] arr=new int[][]{
                {1,0,1},
                {1,1,1},
                {1,1,0},

        };
        flipAndInvertImage(arr);
        for (int i = 0; i < arr.length; i++) {

            System.out.println(Arrays.toString(arr[i]));
        }

    }
    private static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {

            reverse(A[i],0,A[0].length-1);
        }
        return A;
    }


    /**
     * 递归的方式（减而治之）
     *
     * @param arr
     * @param
     */
    private static void reverse(int[] arr, int low, int high) {
        if (high > low) {
            swap(arr, low, high);
            reverse(arr, ++low, --high);

        } else if(high==low) {
            //递归基
            invert(arr,low);
        }
    }

    /**
     * 交换数组中的两元素
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        invert(arr,i);
        invert(arr,j);
    }

    private static void invert(int[] arr,int index){
        if(arr[index]==0){
            arr[index]=1;
        }else{
            arr[index]=0;
        }
    }

}
