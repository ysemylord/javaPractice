package holdObject;


import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class foreachDemo {
    public static void main(String[] args) {
        useCollection();
        useForeach();
        useForeachWithReverseIterable();
    }

    /**
     * foreach语句使用Iterable接口来在序列中移动
     * Colloction继承实现了Iterable接口
     */

    private static void useCollection() {
        Collection<String> stringCollection = new ArrayList<>(Arrays.asList("1", "2", "3"));
        for (String elem : stringCollection) {
            System.out.println(elem);
        }
    }

    /**
     * foreach语句使用Iterable接口来在序列中移动
     * MyCollection2实现了Iterable接口
     */
    private static void useForeach() {
        MyCollection2 myCollection = new MyCollection2();
        for (String string : myCollection) {
            System.out.println(string);
        }
    }

    /**
     * foreach语句使用Iterable接口来在序列中移动
     * reverseIterable（）方法返回一个Iterable接口
     */
    private static void useForeachWithReverseIterable() {
        MyCollection2 myCollection = new MyCollection2();
        for (String string : myCollection.reverseIterable()) {
            System.out.println(string);
        }
    }



}

class MyCollection2 implements java.lang.Iterable<String> {
    private String[] datas = new String[]{"1", "2", "3", "4"};
    private int index = 0;
    private int revereseIndex = datas.length - 1;

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return index < datas.length;
            }

            @Override
            public String next() {
                return datas[index++];
            }
        };
    }

    public Iterable<String> reverseIterable() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    @Override
                    public boolean hasNext() {
                        return revereseIndex >= 0;
                    }

                    @Override
                    public String next() {
                        return datas[revereseIndex--];
                    }
                };
            }
        };
    }


}
