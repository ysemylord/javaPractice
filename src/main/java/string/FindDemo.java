package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDemo {
    public static void main(String[] args) {
        Matcher m = Pattern
                .compile("\\w+")
                .matcher("Evening is full of the linnet's wings");
        while(m.find()){
            System.out.print(m.group()+" ");
        }
        System.out.println();
        int i=0;
        while(m.find(i)){//重置匹配器，并从字符序列的i处开始查找
            System.out.print(m.group()+" ");
            i++;
        }

    }
}
