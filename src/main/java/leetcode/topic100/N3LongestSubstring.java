package leetcode.topic100;

import java.util.HashSet;

public class N3LongestSubstring {

    /**
     * 时间复杂度为O(n^2)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;

        //这里使用HashSet存储子串的元素，是因为HashSet查找某个元素的时间复杂度可以视为O(1)
        HashSet<Character> hashSet = new HashSet<>();
        int strLength = s.length();

        for (int i = 0; i < strLength; i++) {
            hashSet.clear();
            for (int j = i; j < strLength; j++) {
                char element = s.charAt(j);
                if (!hashSet.contains(element)) {
                    hashSet.add(element);
                    int nowSubStringLength = hashSet.size();
                    if (nowSubStringLength > longestLength) {
                        longestLength = nowSubStringLength;
                    }
                }else{
                    break;
                }
            }
        }
        return longestLength;
    }


}
