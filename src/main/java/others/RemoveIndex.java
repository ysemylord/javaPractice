package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveIndex {
    public static void main(String[] args) {
        List<String> datas=new ArrayList<>(Arrays.asList("1","2","3","4"));
        System.out.println(datas);
        datas.remove(1);
        datas.add(1,"2dd");
        System.out.println(datas);
    }
}
