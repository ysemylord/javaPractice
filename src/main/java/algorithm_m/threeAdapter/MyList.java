package algorithm_m.threeAdapter;

/**
 * 列表结构
 * 其实是一个双向链表
 */
public class MyList {
    int size = 0;

    public class ListNode {
        public int data;
        public ListNode pre;
        public ListNode succ;

        public ListNode(int data, ListNode pre, ListNode succ) {
            this.data = data;
            this.pre = pre;
            this.succ = succ;
        }

        public ListNode() {
        }

        /**
         * 将元素e当作为前节点的前驱插入
         *
         * @param e
         * @return
         */
        public ListNode insertAsPre(int e) {
            ListNode listNode = new ListNode(e, pre, this);
            pre.succ = listNode;
            pre = listNode;
            return listNode;
        }

        /**
         * 将元素e作为当前节点的后继插入
         *
         * @param e
         * @return
         */
        public ListNode insertAsSucc(int e) {
            ListNode listNode = new ListNode(e, this, succ);
            succ.pre = listNode;
            succ = listNode;
            return listNode;
        }

        /**
         * 在链表中删除当前元素
         *
         * @return
         */
        public int remove() {
            succ.pre = pre;
            pre.succ = succ;
            return data;
        }

        public int data() {
            return data;
        }

    }

    private ListNode header, tailer;//作为哨兵的头尾

    /**
     * 创建列表时，初始化头尾元素
     */
    public MyList() {
        init();
    }

    private void init() {
        header = new ListNode();
        tailer = new ListNode();
        header.pre = null;
        header.succ = tailer;
        tailer.pre = header;
        tailer.succ = null;
        size = 0;
    }

    /**
     * 将e当做首元素插入
     * 即：将e当做header的后继插入
     *
     * @param e
     * @return
     */
    public ListNode insertAsFisrt(int e) {
        size++;
        return header.insertAsSucc(e);
    }

    /**
     * 将元素e当做末尾元素插入
     * 即：将元素e当做tailer的前驱插入
     *
     * @param e
     * @return
     */
    public ListNode insertAsLast(int e) {
        size++;
        return tailer.insertAsPre(e);
    }

    /**
     * 将e元素当做p的前驱插入
     *
     * @param p
     * @param e
     * @return
     */
    public ListNode insertA(ListNode p, int e) {
        size++;
        return p.insertAsPre(e);
    }

    /**
     * 将e节点当做p的后继插入
     *
     * @param p
     * @param e
     * @return
     */
    public ListNode insertB(ListNode p, int e) {
        size++;
        return p.insertAsSucc(e);
    }

    /**
     * 寻秩访问
     *
     * @param rank 0<=rank<size
     */

    public ListNode get(int rank) {
        ListNode p = first();//p先指向首部元素
        while (rank-- > 0) {
            p = p.succ;
        }
        return p;
    }


    /**
     * 无序列表
     * 在p的前n个元素中查找e(不包含p)
     *
     * @param e
     * @param n
     * @param p
     * @return
     */
    public ListNode find(int e, int n, ListNode p) {
        while (n-- > 0) {
            p = p.pre;
            if (p.data == e) {
                return p;
            }
        }
        return null;
    }

    /**
     * 有序列表
     * 在p的前n个元素中查找e(不包含p)
     *
     * @param e
     * @param n
     * @param p
     * @return 小于等于e的元素
     * 因为要返回小于等于e的元素，但是可能first.data>e,所以为了符合语义，返回de节点可能是
     * header.(首部哨兵其值负无穷，尾部哨兵其值正无穷)
     */
    public ListNode search(int e, int n, ListNode p) {

        while (n-- >= 0) {
            p = p.pre;
            if (p.data <= e) {
                break;
            }
        }
        return p;//可能返回header
    }

    /**
     * 通过复制列表自p起的前n项创建新列表
     *
     * @param p
     * @param n
     * @return
     */
    private void copyNodes(ListNode p, int n) {
        init();
        while (n-- > 0) {
            insertAsLast(p.data);//把新元素作为末尾元素插入
            p = p.succ;
        }
    }

    /**
     * 通过复制自节点P位置起的n个元素，创建新的列表
     *
     * @param p
     * @param n
     */
    public MyList(ListNode p, int n) {
        copyNodes(p, n);
    }

    /**
     * 通过复制列表list创建新的列表
     *
     * @param list
     */
    public MyList(MyList list) {
        copyNodes(list.first(), list.size);
    }

    /**
     * 通过赋值列表list从rank位置起的n个节点创建新的元素
     *
     * @param list
     * @param rank
     * @param n
     */
    public MyList(MyList list, int rank, int n) {
        copyNodes(list.get(rank), n);
    }

    public int remove(ListNode p) {
        p.remove();
        size--;
        return p.data;
    }

    public int size() {
        return size;
    }

    /**
     * 去除重复元素
     *
     * @return 数组去重后大小的变化
     */
    public int duplicate() {
        if (size() < 2) {
            return 0;
        }
        int oldSize = size();
        ListNode p = first();//p从第一个元素起；
        int rank = 1;
        while ((p = p.succ) != tailer) {
            ListNode q = find(p.data, rank, p);
            if (q != null) {
                remove(q);
            }
            rank++;
        }
        return oldSize - size();
    }

    /**
     * 有序列表去重
     *
     * @return
     */
    public int unique() {
        if (size() < 2) {
            return 0;
        }
        int oldSize = size();
        ListNode p = first();
        ListNode q;
        while ((q = p.succ) != tailer) {
            if (q.data == p.data) {//出现重复元素
                remove(q);
            } else {
                p = q;
            }
        }


        return oldSize - size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode p = first();
        while (p.succ != null) {
            stringBuilder.append(p.data + " ");
            p = p.succ;
        }
        return stringBuilder.toString();
    }

    public ListNode first() {
        return header.succ;
    }

    public ListNode last() {
        return tailer.pre;
    }
}
