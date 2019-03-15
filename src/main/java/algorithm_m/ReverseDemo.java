package algorithm_m;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒置数组
 */
public class ReverseDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4,5};
        reverse(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        iteration(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
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

        } else {
                  //递归基
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
    }




    private static void iteration(int[] arr,int low,int high){
        int temp=0;
        for (int i = low; i < (low+high)/2; i++) {
            int left=i;
            int right=high-i;
            swap(arr,left,right);
        }
    }

}
