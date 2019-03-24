package leetcode.littleTips;

import java.util.ArrayList;
import java.util.List;

public class ClassicDoubleCircle {
    /**
     * 例如：找出字符串"abcd"的所有子串
     * a ab abc abcd
     * b bc bcd
     * c cd
     * d
     *
     * @param str
     */
    private static void doubleCircle(char str[]) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            list.clear();
            for (int j = i; j < str.length; j++) {
                list.add(str[j]);
                listToString(list);
            }
        }
    }

    private static void listToString(List<Character> characterList) {
        for (int i = 0; i < characterList.size(); i++) {
            System.out.print(characterList.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        doubleCircle(new char[]{'a','b','c','d'});
    }
}
