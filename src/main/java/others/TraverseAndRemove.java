package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 遍历数组的同时删除数组元素
 */
public class TraverseAndRemove {

    public static void main(String[] args) {
        //errorOne();
        //error2();
        ok();

    }

    private static void ok() {
        List<String> stringList = new ArrayList(Arrays.asList("1", "2", "3", "4"));
        java.util.Iterator<String> iterable=stringList.iterator();
        while(iterable.hasNext()){
            String element=iterable.next();
            if (element.equals("2")) {
                iterable.remove();//使用迭代器器的remove方法
                continue;
            }
            System.out.println(element);
        }
    }

    /**
     * 抛出ConcurrentModificationException异常
     */
    private static void error2() {
        List<String> stringList = new ArrayList(Arrays.asList("1", "2", "3", "4"));
        for (String element:stringList) {
            if (element.equals("1")) {
                stringList.remove(element);
                continue;
            }
            System.out.println(element);
        }
    }

    /**
     * 遍历不完整
     */
    private static void errorOne() {
        List<String> stringList = new ArrayList(Arrays.asList("1", "2", "3", "4"));
        for (int i = 0; i < stringList.size(); i++) {
            String element = stringList.get(i);
            if (i == 1) {
                stringList.remove(element);
                continue;
            }
            System.out.println(element);
        }
    }
}
