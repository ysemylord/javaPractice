package holdObject.accessCollectionElement;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AccessSetElement {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("3");

        //foreach 遍历
        for (String elem : set) {
            System.out.println(elem);
        }

        //iterator 遍历
        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()){
            String elem=iterator.next();
            System.out.println(elem);
        }
    }
}
