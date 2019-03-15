package algorithm_m;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] arr=new int[]{4,2,7,4,3};
        bubbleSort(arr,arr.length);

    }

    /**
     * 冒泡排序
     * 1.问题：给一个序列（按升序）排序
     * 2.观察： 如果一个序列有序，则相令邻的元素都是都是有序的；否则总存相邻的两个元素，是逆序的
     * 3.思路： 一遍遍扫描序列，如果存在逆序的相邻元素，则交互。直到出现一次扫描，没有发现逆序的相邻元素
     *
     * @param arr
     * @param n
     *
     * 冒泡排序的优化：
     * 观察：每一次冒泡排序完成后，最大的元素都在最后（所以这也是为什么叫冒泡排序的原因），所以
     * 每次冒泡排序后，可以将问题的规模减去一:n-1;
     */
    private static void bubbleSort(int[] arr,int n){
         boolean sorted=false;
         while(!sorted) {
             sorted=true;
             for (int i = 1; i < n; i++) {
                 if (arr[i - 1] > arr[i]) {
                     swap(arr, i - 1, i);
                     sorted=false;
                 }
             }
             n=n-1;
             System.out.println(Arrays.toString(arr));
         }
    }

    /**
     * 交换数组中的两元素
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr,int i,int j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
    }
}
