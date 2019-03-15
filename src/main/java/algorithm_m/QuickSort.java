package algorithm_m;

import java.util.Arrays;

/**
 * 快速排序
 * 思路
 * 1.将一个序列按照一个轴点Pivot划分为两个子序列L,S，
 * 使得序列L中的元素都小于轴点Pivote
 * 使得序列S中的元素都不小于轴点Pivote
 * 2. 递归求解，分而治之
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arrs = new int[]{6, 3, 8, 1, 5, 9, 8, 4, 5, 7, 2};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arrs, 0, arrs.length);
        System.out.println(Arrays.toString(arrs));
    }

    public void quickSort(int arr[], int low, int high) {//(low,hight]
        if (high - low <= 1) {//单元素天然有序
            return;
        }
        int mid = partition(arr, low, high - 1);
        quickSort(arr, low, mid);
        quickSort(arr, mid + 1, high);
    }

    private int partition(int[] arr, int low, int high) {//[low,high]
        System.out.println("原数组"+Arrays.toString(arr));
        System.out.println("划分子序列开始");
        int pivote = arr[low];//选取轴点
        int mid = low;//mid指向子序列L的末元素，初始为low
        int k = low + 1;//k指向子序列G末元素的下一个,即逻辑上缩短的原序列的首元素
        while (k <= high) {
            if (arr[k] < pivote) {//k指向的元素小于轴点，将K指向的元素归入L
                swap(arr, mid + 1, k);
                mid++;
                k++;
            } else {//将K指向的元素归于G
                k++;
            }
            System.out.println("子序列划分 "+Arrays.toString(arr));

        }
        swap(arr, low, mid);//交换轴点和mid
        System.out.println("交换轴点 "+Arrays.toString(arr));
        System.out.println("一次分割完成\n");
        return mid;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
