package algorithm_m.tenAdapter;

import java.util.Vector;
import java.util.concurrent.ExecutionException;

public class PQ_complHeap<T> extends Vector<T> {
    public void insert(T e) throws Exception {
        super.add(e);//插入到向量尾部，即堆底层
        percolateUp(size() - 1);
    }

    /**
     * 上滤第i个元素，保持堆序性
     *
     * @param i
     * @return
     * @throws Exception
     */
    private int percolateUp(int i) throws Exception {
        while (parentValid(i)) {
            int parent = parent(i);
            if (lt(i, parent)) {
                swap(i, parent);
            } else {
                return i;
            }

        }
        return i;
    }

    private boolean lt(int i, int parent) throws Exception {
        T rankE = get(i);
        T parentE = get(parent);
        if (rankE instanceof Comparable) {
            Comparable comparableE = (Comparable) rankE;
            Comparable comparableP = (Comparable) parentE;
            if (comparableE.compareTo(comparableP) > 0) {
                return true;
            } else {
                return false;
            }
        }
        {
            throw new Exception("can't compare");
        }
    }

    /**
     * 第i个元素的父节点是否可达
     *
     * @param i
     * @return
     */
    private boolean parentValid(int i) {
        if ((i - 1) / 2 < 0) {
            return false;
        }
        return true;
    }

    /**
     * 获取第i个元素的父节点的位置
     *
     * @param i
     * @return
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 交换第i个元素和第j个元素的值
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    /**
     * 获取堆顶元素
     *
     * @return
     */
    private T getMax() {
        return get(0);
    }

    private T delMax() throws Exception {
        T max = get(0);
        elementData[0] = elementData[elementCount - 1];//堆底元素代替堆顶
        elementCount--;//删除原来的堆底元素
        percolateDown(0);
        return max;
    }

    /**
     * 下滤第i个元素
     *
     * @param i
     */
    private void percolateDown(int i) throws Exception {
        int j;//作为交换的child
        while (i != (j = properChild(i))) {//还不满足堆序性
            swap(i, j);
        }
    }

    /**
     * 选出i,leftChild,rightChild的最大者
     *
     * @param i
     * @return
     * @throws Exception
     */
    private int properChild(int i) throws Exception {
        int leftChild = i * 2 + 1;
        int rightChild = (i + 1) * 2;
        int max = i;
        if (leftChild < size() && rightChild < size()) {//两个孩子都存在
            if (lt(leftChild, rightChild)) {
                max = leftChild;
            } else {
                max = rightChild;
            }
            if (lt(i, max)) {
                max = i;
            }
        } else if (rightChild >= size() && leftChild < size()) {//只有左孩子
            if (lt(leftChild, i)) {
                max = leftChild;
            } else {
                max = i;
            }
        } else {//两个孩子都不存在
            max = i;
        }
        return i;

    }
}
