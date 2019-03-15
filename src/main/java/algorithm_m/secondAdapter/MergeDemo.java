package algorithm_m.secondAdapter;

import java.util.Arrays;

public class MergeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 6,2,7,10};
        mergeSorted(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     * @param arr
     * @param low
     * @param high
     */
    private static void mergeSorted(int arr[], int low, int high) {
        if (high - low < 2) return;//recursion base

        //减而治之
        int mid = (high + low) / 2;
        mergeSorted(arr, low, mid);//左边
        mergeSorted(arr, mid, high);//右边
        merge(arr, low, mid, high);

    }

    /**
     * 合并两个有序数组，
     * 这两个有序数组分别是
     * [low,mid),[mid,high)
     *
     * @param arrA
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(int[] arrA, int low, int mid, int high) {
        int[] arrB = new int[mid - low];
        int[] arrC = new int[high - mid];
        for (int m = 0; m < arrB.length; m++) {
            arrB[m] = arrA[low+m];
        }
        for (int n = 0; n < arrC.length; n++) {
            arrC[n] = arrA[mid + n];
        }



        int i = low, j = 0, k = 0;
        while (j < arrB.length || k < arrC.length) {
            if ((j < arrB.length) && (k >= arrC.length || arrB[j] < arrC[k])) {
                arrA[i++] = arrB[j++];
            }
            if (k < arrC.length && (j >= arrB.length || arrC[k] < arrB[j])) {
                arrA[i++] = arrC[k++];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(arrA,low,high)));
        System.out.println(Arrays.toString(arrB));
        System.out.println(Arrays.toString(arrC));
        System.out.println();
    }

    /**
     * 合并两个有序数组
     *
     * @param arrA
     * @param arrB
     */
    private static int[] merge(int arrA[], int arrB[]) {
        int[] arrMerge = new int[arrA.length + arrB.length];
        for (int i = 0, j = 0, k = 0; i < arrA.length || j < arrB.length; ) {
            if (i < arrA.length && (j >= arrB.length || arrA[i] < arrB[j])) {
                arrMerge[k++] = arrA[i++];
            }
            if (j < arrB.length && ((i >= arrA.length) || (arrB[j] < arrA[i]))) {
                arrMerge[k++] = arrB[j++];
            }

        }
        return arrMerge;
    }
}
