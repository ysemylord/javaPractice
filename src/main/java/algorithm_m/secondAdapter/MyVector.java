package algorithm_m.secondAdapter;

import algorithm_m.Fib.Fib;

import java.util.Arrays;

/**
 * T表示要存储的数据的类型
 * 1.明确下三个概念
 * 秩:数组索引
 * 容量：数组的大小
 * 规模：数组已存放的元素个数，同时指明了最后一个元素的位置（size-1）
 * 注意:为了简化过程，比较相等使用的而是==，比较大小使用的是<,>（严谨来说应该使用equal,comparable,comparator）
 *
 * @param
 */
public class MyVector<T> {
    int size, capacity;//规模，容量
    T[] elementData;//真实的存放元素的数组
    public final static int DEFAULT_CAPACITY = 3;


    public MyVector(int capacity) {
        this.capacity = capacity;
        elementData = (T[]) new Object[capacity];
        size = 0;
    }

    public MyVector() {
        this(DEFAULT_CAPACITY);
    }


    public MyVector(Object[] old, int length) {
        this(old, 0, length);
    }

    public MyVector(Object[] old, int low, int high) {

        capacity = 2 * (high - low);
        size = 0;
        elementData = (T[]) new Object[capacity];
        for (int i = low; i < high; i++) {
            elementData[size++] = (T) old[i];
        }

    }

    @Override
    public String toString() {

        return Arrays.toString(elementData);
    }

    /**
     * 扩充容量
     */
    public void expand() {
        if (size < capacity) return;
        T[] oldElementData = elementData;
        capacity = Math.max(capacity, DEFAULT_CAPACITY);//不小于默认的最小容量
        T[] newElimentData = (T[]) new Object[capacity <<= 1];//capacity<<=1相当于capacity=capacity*2
        for (int i = 0; i < size; i++) {
            newElimentData[i] = oldElementData[i];
        }
        elementData = newElimentData;
    }

    /**
     * @param rank
     * @param element
     * @return
     */
    public int insert(int rank, T element) {
        expand();//有必要，先扩容
        for (int i = size; i > rank; i--) {//
            elementData[i] = elementData[i - 1];
        }
        elementData[rank] = element;
        size++;
        return rank;
    }

    /**
     * 删除[low,hig）区间内的函数
     *
     * @param low
     * @param high
     * @return 删除元素的个数
     */
    public int remove(int low, int high) {
       /* for(int i=high;i<size;i++){
            elementData[low++]=elementData[i];

        }*/

        while (high < size) {
            elementData[low++] = elementData[high++];
        }
        size = low;
        return high - low;
    }

    /**
     * 删除rank位置处的元素
     *
     * @param rank
     * @return 被删除的元素
     */
    public T remove(int rank) {
        T element = elementData[rank];
        remove(rank, rank + 1);
        return element;

    }


    public int find(T element) {
        return find(element, 0, size);
    }

    public T get(int rank) {
        return elementData[rank];
    }

    /**
     * 查找的空间[low,high)
     *
     * @param element
     * @param low
     * @param high
     * @return 返回查找的元素位置，如果返回值小于low,证明没有查找到改元素
     */
    public int find(T element, int low, int high) {
        //从低位向高位索引
      /*
        while((low++)<=(high)){
            if(elementData[low]==element){
                break;
            }
        }
        return low;*/

        //从高位向低位索引
        while (high-- > low) {
            if (elementData[high].equals(element)) {
                break;
            }
        }
        return high;//high<low则查找失败失败
    }

    /**
     * 针对无序向量的唯一化
     *
     * @return 唯一化前后的数量差
     */
    public int deduplicate() {
        int i = 1;
        int oldSize = size;
        while (i < size) {
            if (find(elementData[i], 0, i) < 0) {//无重复元素
                i++;
            } else {//有与element[i]重复的元素
                remove(i);//remove中会对size进行调整
            }
        }
        return oldSize - size;
    }

    /**
     * 针对已经 有序的有序向量的唯一化(低效版)
     * 注:有序向量相同的元素紧邻
     *
     * @return 唯一化前后的数量差
     */
    public int uniquify() {
        int i = 0;
        int oldSize = size;
        while (i <= size - 1) {
            if (elementData[i] == elementData[i - 1]) {
                remove(i);
            } else {
                i++;
            }
        }
        return oldSize - size;
    }

    /**
     * 有序向量删除重复元素的高效算法，
     * 只做了逻辑上的删除，并没有做物理上的删除
     *
     * @return
     */
    public int unique() {
        int i = 0, j = 0;
        int oldSize = size;
        while (++j < size) {
            if (elementData[j] != elementData[i]) {//
                elementData[++i] = elementData[j];
            }
        }
        size = i + 1;
        return oldSize - size;
    }

    /**
     * 判断有序向量是否有序
     *
     * @return
     */
    public int disordered() {
        int i = 0;
        int count = 0;
        while (i <= size - 1) {
            if (elementData[i] instanceof Comparable) {
                Comparable comparable1 = (Comparable) elementData[i];
                Comparable comparable2 = (Comparable) elementData[i + 1];
                if (comparable1.compareTo(comparable2) > 0) {//相邻元素顺序
                    count++;
                }
            } else {
                throw new RuntimeException("没有实现Comparable接口，不能调用disordered");
            }
            i++;
        }
        return count;
    }

    public int binarySearchA(T element, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (elementData[mid] instanceof Comparable) {
                Comparable findElemnt = (Comparable) element;
                Comparable midElement = (Comparable) elementData[mid];

                if (findElemnt.compareTo(midElement) < 0) {
                    high = mid;
                } else if (midElement.compareTo(findElemnt) < 0) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                throw new RuntimeException("未实现Comparable接口");
            }
        }
        return -1;
    }

    /**
     * 优点：平衡查找过程，最好和最坏情况下的查找长度相差不大，性能稳定
     * 缺点：不能及时命中
     *
     * @param element
     * @param low
     * @param high
     * @return
     */
    public int binarySearchB(T element, int low, int high) {
        Comparable findElement = (Comparable) element;
        while (high - low > 1) {//长度为1时跳出循环
            int mid = (low + high) / 2;
            if (elementData[mid] instanceof Comparable) {
                Comparable midElement = (Comparable) elementData[mid];
                if (findElement.compareTo(midElement) < 0) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
        }
        return elementData[low] == element ? low : -1;

    }

    /**
     * 不仅平衡了查找过程，
     * 而且返回的值符合语义：
     * 返回 不大于e的最大元素的秩
     *
     * @param element
     * @param low
     * @param high
     * @return
     */
    public int binarySearchC(T element, int low, int high) {
        Comparable findElement = (Comparable) element;
        while (high > low) {
            int mid = (low + high) / 2;
            Comparable midElement = (Comparable) elementData[mid];
            if (findElement.compareTo(midElement) < 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return --low;
    }


    /**
     * 斐波拉契查找
     *
     * @param element
     * @param low
     * @param high
     * @return 查找的元素的位置
     */
    public int fibSearch(T element, int low, int high) {
        Comparable findElement = (Comparable) element;
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

            Comparable pivoteElement = (Comparable) elementData[pivote];
            if (findElement.compareTo(pivoteElement) < 0) {
                high = pivote;
            } else if (pivoteElement.compareTo(findElement) < 0) {
                low = pivote + 1;
            } else {
                return pivote;
            }
        }
        return -1;
    }


    //<editor-fold desc="冒泡排序>

    /**
     * 向量的冒泡排序
     */
    public void bubbleSortA() {
        bubbleSortA(0, size);
    }

    /**
     * 对[low,high)区间进行冒泡排序
     *
     * @param low
     * @param high
     */
    private void bubbleSortA(int low, int high) {
        while (!bubbleA(low, high)) {
            high--;
        }
    }

    /**
     * 一趟扫描交换
     *
     * @return 在本趟扫描中是否进行了交换，如果返回false,表示没有进行交换，证明向量已经有序
     */
    private boolean bubbleA(int low, int high) {
        boolean sorted = true;
        T temp;
        while (++low < high) {

            Comparable lowElement = (Comparable) elementData[low];
            Comparable lowerElement = (Comparable) elementData[low - 1];
            if (lowElement.compareTo(lowerElement) < 0) {
                //交换
                temp = elementData[low];
                elementData[low] = elementData[low - 1];
                elementData[low - 1] = temp;

                sorted = false;
            }
        }
        return sorted;
    }


    public void bubbleSortB() {
        bubbleSortB(0, size);
    }


    /**
     * 再次改进的冒牌排序
     *
     * @param low
     * @param high
     */
    private void bubbleSortB(int low, int high) {
        while ((low) < (high = bubbleB(low, high))) {
        }
    }

    /**
     * 一趟扫描交换
     *
     * @return 记录的最右侧逆序对的位置
     */
    private int bubbleB(int low, int high) {
        int last = low;//最右侧逆序对的位置初始化为[low-1,low]
        T temp;

        while (++low < high) {

            Comparable lowElement = (Comparable) elementData[low];
            Comparable lowerElement = (Comparable) elementData[low - 1];

            if (lowElement.compareTo(lowerElement) < 0) {
                //交换
                temp = elementData[low];
                elementData[low] = elementData[low - 1];
                elementData[low - 1] = temp;

                last = low;
            }
        }
        return last;
    }

    //</editor-fold>


    private void mergeSorted(int low, int high) {
        if (high - low < 2) return;//recursion base

        //减而治之
        int mid = (high + low) / 2;
        mergeSorted(low, mid);//左边
        mergeSorted(mid, high);//右边
        merge(low, mid, high);

    }

    /**
     * 合并两个有序数组，
     * 这两个有序数组分别是
     * [low,mid),[mid,high)
     *
     * @param low
     * @param mid
     * @param high
     */
    private void merge(int low, int mid, int high) {
        T[] arrB = (T[]) new Object[mid - low];
        T[] arrC = (T[]) new Object[high - mid];
        for (int m = 0; m < arrB.length; m++) {
            arrB[m] = elementData[low + m];
        }
        for (int n = 0; n < arrC.length; n++) {
            arrC[n] = elementData[mid + n];
        }


        int i = low, j = 0, k = 0;
        while (j < arrB.length || k < arrC.length) {

            Comparable jElement = (Comparable) arrB[j];
            Comparable kElement = (Comparable) arrC[k];
            if ((j < arrB.length) && (k >= arrC.length || jElement.compareTo(kElement) < 0)) {
                elementData[i++] = arrB[j++];
            }
            if (k < arrC.length && (j >= arrB.length || kElement.compareTo(jElement) < 0)) {
                elementData[i++] = arrC[k++];
            }
        }
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int size() {
        return size;
    }
}
