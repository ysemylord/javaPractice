package dataStruct;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleLRU extends LinkedHashMap {
    private int mMaxSize = 3;

    public SimpleLRU() {
        super(16, 0.45f, true);
    }

    public void setmMaxSize(int mMaxSize) {
        this.mMaxSize = mMaxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        if (size() > mMaxSize) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SimpleLRU myLRU=new SimpleLRU();
        myLRU.put("1",1);
        myLRU.put("2",2);
        myLRU.put("3",3);
        myLRU.put("4",4);
        myLRU.put("5",5);

        System.out.println("the size of LRU is "+myLRU.size());

    }
}
