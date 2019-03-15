package algorithm_m;

import java.util.Arrays;

/**
 * 找出数组中最大的两个元素
 */
public class Max2Demo {
    public static void main(String[] args) {
        int arr[] = new int[]{100,  32,343, 23, 90};
        //function1(arr, 0, arr.length);


       // function2(arr, 0, arr.length);

        int[] max=new int[2];
       reverseMax2(arr,0,arr.length,max);
        System.out.println(Arrays.toString(max));

    }

    /**
     * 三次遍历
     * 数组范围arr[low,high)
     * 事件复杂度：O（n）
     * 最好情况：2n-3
     * 最坏情况 2n-3
     *
     * @param arr
     * @param low
     * @param high
     */
    private static void function1(int[] arr, int low, int high) {
        int max1 = low, max2;
        for (int i = low + 1; i < high; i++) {
            if (arr[max1] < arr[i]) {
                max1 = i;
            }
        }

        if (max1 == low) {//考虑最大的元素刚好是第一个元素的情况
            max2 = max1 + 1;
        } else {
            max2 = low;
        }
        for (int i = low + 1; i < max1; i++) {
            if (arr[max2] < arr[i]) {
                max2 = i;
            }
        }

        for (int i = max1 + 1; i < high; i++) {
            if (arr[max2] < arr[i]) {
                max2 = i;
            }
        }

        System.out.println("max2 is " + arr[max1] + "|" + arr[max2]);


    }

    /**
     * 一次遍历
     * 时间复杂度 O(n)
     * 最好情况  n-2
     * 最坏情况  2n-3
     *
     * @param arr
     * @param low
     * @param high
     */
    private static void function2(int[] arr, int low, int high) {
        //因为java中没有指针，所以用max[0]指向最大值得为之，max[1]指向第二大值的位置
        int[] max = new int[2];
        max[0] = low;
        max[1] = low + 1;
        swap(arr, max);

        for (int i = low + 2; i < high; i++) {
            if (arr[i] > arr[max[1]]) {
                max[1] = i;
                if (arr[max[1]] > arr[max[0]]) {
                    swap(arr, max);
                }
            }
        }

        System.out.println("max 2 is " + arr[max[0]] + "|" + arr[max[1]]);

    }

    private static void swap(int[] arr, int[] max) {
        if (arr[max[0]] < arr[max[1]]) {
            int temp = max[0];
            max[0] = max[1];
            max[1] = temp;
        }

    }


    /**
     * 递归求解数组中的两个最大值
     *
     * @param arr
     * @param low
     * @param hig
     * @param max max[0]存放最大元素的位置，max[1]存放最小元素的位置
     */
    private static void reverseMax2(int[] arr, int low, int hig, int max[]) {

        //递归基
        if (low + 2 == hig) {//2个元素
            findMaxInTwo(arr, low, low + 1, max);
            return;
        } else if (low + 3 == hig) {//3个元素
            findMaxInThree(arr, low, hig, max);

            return;
        }

        int mid = (low + hig) / 2;
        int[] maxL = new int[2];
        reverseMax2(arr, low, mid, maxL);

        int[] maxR = new int[2];
        reverseMax2(arr, mid, hig, maxR);

        int maxL1 = maxL[0];
        int maxL2 = maxL[1];
        int maxR1 = maxR[0];
        int maxR2 = maxR[1];
        if (arr[maxL1] > arr[maxR1]) {
            max[0] = maxL1;
            max[1] = arr[maxL2] > arr[maxR1] ? maxL2 : maxR1;
        } else {
            max[0] = maxR1;
            max[1] = arr[maxR2] > arr[maxL1] ? maxR2 : maxL1;
        }


    }

    private static void findMaxInThree(int[] arr, int low, int hig, int[] max) {
        int max1 = low, max2 = low + 1;
        if (arr[max1] < arr[max2]) {
            int temp = max1;
            max1 = max2;
            max2 = temp;
        }
        if (arr[low + 2] > arr[max1]) {
            int temp = max1;
            max1 = low + 2;
            max2 = temp;
        } else if (arr[low + 2] > arr[max2]) {
            max2 = low + 2;
        }
        max[0] = max1;
        max[1] = max2;
        return;
    }


    private static void findMaxInTwo(int arr[], int low, int high, int[] max) {
        int max1 = low, max2 = low + 1;
        if (arr[max1] < arr[max2]) {
            int temp = max1;
            max1 = max2;
            max2 = temp;
        }
        max[0] = max1;
        max[1] = max2;
    }
}
