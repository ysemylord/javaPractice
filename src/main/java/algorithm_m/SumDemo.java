package algorithm_m;

/**
 * 求和0
 */
public class SumDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5,6};
        System.out.println(iterationFunctoin(arr) + "");
        System.out.println(recursionFunction(arr, arr.length));
        System.out.println(divideConquer(arr,0,arr.length-1));
    }


    /**
     * 迭代求和
     *
     * @param arr
     * @return
     */
    private static int iterationFunctoin(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * 减而治之
     *
     * @param arr
     * @param length
     * @return
     */
    private static int recursionFunction(int[] arr, int length) {
        if (length < 1) {
            return 0;
        }
        return recursionFunction(arr, length - 1) + arr[length - 1];
    }


    /**
     * 分而治之
     *求解数组arr,[low,high]的和
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int divideConquer(int[] arr, int low, int high) {
        if (low == high) {
            return arr[low];
        }
        int mid = (low + high) >> 1;
        return divideConquer(arr, low, mid) + divideConquer(arr, mid + 1, high);
    }
}
