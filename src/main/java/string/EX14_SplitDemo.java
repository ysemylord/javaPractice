package string;

import java.util.Arrays;

public class EX14_SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        String[] res1=input.split("!!");
        String[] res2=input.split("!!",3);
        System.out.println("res1 "+ Arrays.toString(res1));
        System.out.println("res2 "+Arrays.toString(res2));
    }
}
