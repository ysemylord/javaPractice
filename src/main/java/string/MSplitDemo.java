package string;

import java.util.Arrays;

/**
 * 分割|要使用\\|
 */
public class MSplitDemo {
    public static void main(String[] args) {
        String input = "T*his\nunusu|al\n use\nof exclamat!ion\npoints";
        String[] res1=input.split("\n|\\||\\*|!");
        System.out.println("res1 "+ Arrays.toString(res1));
    }
}
