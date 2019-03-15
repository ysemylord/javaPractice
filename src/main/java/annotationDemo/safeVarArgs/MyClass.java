package annotationDemo.safeVarArgs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyClass {
    public static void outName(String ... names){
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }

    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }

    public static void main(String[] args) {
        m(Arrays.asList("1"), Arrays.asList("2"));
    }



}
