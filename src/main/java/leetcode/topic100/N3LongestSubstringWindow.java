package leetcode.topic100;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class N3LongestSubstringWindow {

    /**
     * abcd
     * [i,j)定位滑动窗口的位置
     * 0<i<n;0<j<n;i<=j;
     * 窗口围[i,j]
     *
     * @param s
     * @return jbpnbwwd
     */
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        int i = 0, j = 0;
        HashSet<Character> hashSet = new HashSet<>();
        int strLength = s.length();
        while (i < strLength && j < strLength) {
            char element = s.charAt(j);
            if (!hashSet.contains(element)) {//窗口右边，向右扩展
                hashSet.add(element);
                j++;
                longestLength = Math.max(hashSet.size(), longestLength);
                System.out.println(longestLength + " add " + Arrays.toString(hashSet.toArray()));
            } else {//窗口左边，向右扩展
                hashSet.remove(s.charAt(i));
                System.out.println(longestLength + " remove  " + Arrays.toString(hashSet.toArray()));
                i++;
            }
        }


        return longestLength;
    }


}
