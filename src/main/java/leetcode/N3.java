package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class N3 {
    public static void main(String[] args) {
        System.out.println(new N3().lengthOfLongestSubstring2("dvdf"));
    }

    /**
     * 方法二：滑动窗口
     * 滑动窗口:
     * [i,j)指示滑动窗口的范围，HashSet存储滑动窗口元素，便于查找和删除
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int ans=0,i=0,j=0;
        Set<Character> set= new HashSet();
        while(i<s.length()&&j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans=Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int curLength=0;
        int maxLength=0;
        char[] charArray=s.toCharArray();
        int p1=0;
        int from=0,end=0;

        while (p1 < s.length()) {
           if(!contains(charArray,from,end,charArray[p1])){
               p1++;
               curLength++;
               end++;
           }else{
               if(curLength>maxLength){
                   maxLength=curLength;
               }
               curLength=0;
               from++;
               end=from;
               p1=from;
           }

        }
        return Math.max(maxLength,curLength);
    }

    private boolean contains(char[] charArray,int from,int end,char checkChar){
        System.out.print("check "+checkChar);
        for(int i=from;i<end;i++){
            if(charArray[i]==checkChar){
                System.out.println("存在");
                return true;
            }
        }
        System.out.println("不存在");
        return false;
    }
}
