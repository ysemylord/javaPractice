package holdObject.accessCollectionElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AccessListElement {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("1", "2", "3"));

        //下标遍历
        for (int i = 0; i < stringList.size(); i++) {
            String elem = stringList.get(0);
            System.out.println(elem);
        }

        //foreach 遍历
        for (String elem : stringList) {
            System.out.println(elem);
        }


        //iterator遍历
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }


    }
}
