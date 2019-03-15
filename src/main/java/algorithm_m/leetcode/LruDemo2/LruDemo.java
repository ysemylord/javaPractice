package algorithm_m.leetcode.LruDemo2;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruDemo {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

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

    private LinkedHashMap<Integer, Integer> linkedHashMap;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>(0, 0.5f, true);

    }

    public void put(int key, int value) {
        linkedHashMap.put(key, value);

        if (linkedHashMap.size() > capacity) {
            Map.Entry<Integer, Integer> toEvict = linkedHashMap.entrySet().iterator().next();
            int keyOldest = toEvict.getKey();
            linkedHashMap.remove(keyOldest);
        }

    }

    public int get(int key) {
        int res;
        Integer integer = linkedHashMap.get(key);
        if (integer == null) {
            res = -1;
        } else {
            res = integer;
        }
        System.out.println("访问到 " + res);
        return res;

    }
}

