package leetcode;


import java.util.HashSet;
import java.util.Set;

public class N2_sup {
    public static void main(String[] args) {
        //printAllSubString("abcdghfgh");
        //System.out.println(aullUnique("abclyyyd"));
    }



    /**
     * 获取字符串的所有子串
     */
    private static void printAllSubString(String string) {
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j <= string.length(); j++) {
                System.out.println(string.substring(i, j));
            }
        }
    }

    /**
     * 判断一个字符串中是否有重复元素
     */
    private static boolean aullUnique(String s) {
        Set<Character> sets = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!sets.add(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
