package leetcode.topic100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class N3LongestSubstringWindowOpt {

    /**
     *
     * 使用HashSet存放窗口内容有一个缺点：
     * 不知道存放元素在原字符串中的位置，这就导致了删除HashSet中重复元素时，只有一个一个的删除
     *
     * 现在使用HashMap存储元素及其在原字符串中的位置
     * @param s
     * @return
     *
     * "tmmzuxt"
     *        j
     *    i
     */
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        int i = 0, j = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int strLength = s.length();
        while (j < strLength) {
            char nowElement = s.charAt(j);
            boolean containsNowElement = hashMap.containsKey(nowElement);
            if(containsNowElement){
                int oldIndex = hashMap.get(nowElement);
                i= Math.max(oldIndex +1,i);
           }
            hashMap.put(nowElement,j);
            longestLength=Math.max(j-i+1,longestLength);
            j++;
        }


        return longestLength;
    }


}
