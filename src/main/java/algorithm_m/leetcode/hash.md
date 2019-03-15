[到底什么是hash?](https://www.zhihu.com/question/26762707)  

hash函数，将任意长度的数据到有限长度的域。  
即输入一串数据，得到固定长度的另一段数据。
作用 
1. 抗碰撞能力：要求输入不同的数据，得到的hash值尽可能不同。  
如:java中使用hash进行管理的数据结构（如HashMap,HashTable）,就需要hash的抗碰撞能力  
  
HashTable中使用hash值确定元素位置，
   1. 做法是获取key的hash值  
   2. 因为hash可能为负，所以[hash&0x7FFFFFF](https://stackoverflow.com/questions/9380670/why-does-java-use-hash-0x7fffffff-tab-length-to-decide-the-index-of-a-key)  
   3. 取余数得到key响应的位置。 
```
    public synchronized V put(K key, V value) {
        // Make sure the value is not null
        if (value == null) {
            throw new NullPointerException();
        }
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
       
    }

```  
HashMap中使用hash值确定元素位置  
1. 获取key的hash值
 本来可以直接使用(n - 1) & hash得到key的位置，但是为了[hashcode中有更多的位生效](https://yikun.github.io/2015/04/01/Java-HashMap%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/)，所以
 把高16bit和低16bit异或了下,所以
2. (h = key.hashCode()) ^ (h >>> 16)
3. 获取key的位置tab\[i = (n - 1) & hash]    
注意：res=a&b res<=min(a,b)
```
  putVal(hash(key), key, value, false, evict);

```

```
  static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

```

```
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        }
```


2. 抗篡改能力