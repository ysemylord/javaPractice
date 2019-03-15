package algorithm_m.Fib;

public class FibSearch {
    public static void main(String[] args) {
        int[] datas = new int[]{0, 1, 2, 3, 4, 5, 6, 90, 8, 9, 10, 11, 12, 13};
        FibSearch fibSearch = new FibSearch();
        int index = fibSearch.search(datas, 7, 0, datas.length);
        System.out.println("在" + index);

    }

    public int search(int[] elementData, int element, int low, int high) {

        Fib fib = new Fib(high - low);//主要是通过Fib数列确定轴点
        while (low < high) {


            /**
             * 借用Fib确定轴点的位置，
             *
             * 轴点的位置为
             * low + fib.get() - 1
             *
             * 轴点的位置不能大意high
             *
             */
            int pivote;
            while (!((pivote = low + fib.get() - 1) < high)) {
                fib.pre();
            }

            System.out.println("轴点" + pivote);

            if (element < elementData[pivote]) {
                high = pivote;
            } else if (elementData[pivote] < element) {
                low = pivote + 1;
            } else {
                return pivote;
            }
        }
        return -1;
    }
}
