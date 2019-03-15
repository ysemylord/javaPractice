package algorithm_m.leetcode.LruDemo1;

public class LruDemo1 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }




}
class LRUCache {
    class Entry {
        Entry before;
        Entry after;
        private int key;
        private int value;


        /**
         * 将自己从链表中删除
         *
         * @param
         * @return
         */
        public void remove() {
            this.before.after = this.after;
            this.after.before = this.before;
        }

        /**
         * 将自己插入到已有结点的前面
         *
         * @param exitEntry
         */
        public void insert(Entry exitEntry) {
            Entry exBefore=exitEntry.before;
            this.before = exBefore;
            this.after = exitEntry;
            exBefore.after=this;
            exitEntry.before=this;

        }
    }

    int capacity=2;
    private LRUCache.Entry header;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        header=new LRUCache.Entry();
        header.after=header;
        header.before=header;

    }
    public void put(int key,int value){
        Entry p=header.after;
        while(p!=header){//删除已有结点
            if(p.key==key){
                p.remove();
                break;
            }
            p=p.after;
        }

        Entry entry=new Entry();
        entry.key=key;
        entry.value=value;
        if(size==capacity){//容量到达上限
            header.after.remove();
            size--;
            System.out.println("删除元素");
        }
        System.out.println("插入元素"+value);
        entry.insert(header);
        size++;
    }
    public int get(int key){
        Entry p=header.after;
        while(p!=header){
            if(p.key==key){
                p.remove();
                p.insert(header);
                System.out.println("返回 "+p.value);
                return p.value;
            }
            p=p.after;
        }
        return -1;
    }
}

