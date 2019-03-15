package dataStruct;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ImprovementLRU<K, V> {
    private LinkedHashMap<K, V> mLinkedHashMap;
    private int mMaxSize;
    private int mTotalSize = 0;

    public ImprovementLRU(int maxSize) {
        this.mMaxSize = maxSize;
        mLinkedHashMap = new LinkedHashMap<K, V>(120, 0.45f, true);
    }

    public void put(K key, V value) {
        int size = sizeOf(key, value);
        mTotalSize += size;
        V oldValue = mLinkedHashMap.put(key, value);
        if (oldValue != null) {
            mTotalSize -= sizeOf(key, oldValue);
        }
        if (mTotalSize > mMaxSize) {
            deleteOldest();
        }
        System.out.println("lru size is "+mTotalSize);
    }

    public V get(K key) {
        return mLinkedHashMap.get(key);
    }

    private void deleteOldest() {
        Map.Entry<K, V> oldestEntry = getEldestEntry();
        if (oldestEntry == null) {
            return;
        }
        mLinkedHashMap.remove(oldestEntry.getKey());
        int oldSize = sizeOf(oldestEntry.getKey(), oldestEntry.getValue());
        mTotalSize -= oldSize;
    }

    //这里为了获取最老的Entry这样写，但是实际上为了效率应该直接想办法获取LinkedHashMap双向
    //链表中的头指针（参考android版本中LinkedHashMap中的eldest(）方法）
    private Map.Entry<K, V> getEldestEntry() {
        Iterator<Map.Entry<K, V>> iterator = mLinkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
           return iterator.next();
        }
        return null;
    }

    public int length(){
        return mLinkedHashMap.size();
    }

    protected int sizeOf(K key, V value) {
        return 1;
    }

    static class Bitamp{
        private int mSize;

        public Bitamp(int mSize) {
            this.mSize = mSize;
        }

        public int getSize() {
            return mSize;
        }

        public void setSize(int mSize) {
            this.mSize = mSize;
        }
    }

    public static void main(String[] args) {
        Bitamp bitamp1=new Bitamp(10);
        Bitamp bitamp2=new Bitamp(20);
        Bitamp bitamp3=new Bitamp(30);



        ImprovementLRU<String ,Bitamp> lru2=new ImprovementLRU<String, Bitamp>(50){
            @Override
            protected int sizeOf(String key, Bitamp value) {
                return value.getSize();
            }
        };

        lru2.put("bitamp1",bitamp1);
        lru2.put("bitamp2",bitamp2);
        lru2.put("bitamp3",bitamp3);

        System.out.println("size of lru is "+lru2.length());


        System.out.println(16&15);
    }

}
