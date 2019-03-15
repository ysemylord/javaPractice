package holdObject;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Iterable {
    public static void main(String[] args) {
        useCollection();
        useIterable();
    }

    private static void useCollection() {
        Collection<String> stringCollection = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Iterator<String> iterator = stringCollection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void useIterable() {
        MyCollection2 myCollection = new MyCollection2();
        Iterator<String> iterator = myCollection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


