package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherAndLookAtFindDemo {
    public static void main(String[] args) {
        Pattern pattern = Pattern
                .compile("Evening.*");
        Matcher m = pattern
                .matcher("Evening is full of the linnet's wings");

        System.out.println(m.matches());

        System.out.println(m.lookingAt());

        m.reset();
        while(m.find()){
            System.out.print(m.group()+" ");
        }
        System.out.println();
        while(m.find(0)){//重置匹配器，并从字符序列的i处开始查找
            System.out.print(m.group()+" ");
            break;
        }

    }
}
