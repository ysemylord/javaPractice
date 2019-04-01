package top100Test;

import algorithm_m.threeAdapter.MyList;
import leetcode.topic100.N3LongestSubstring;
import leetcode.topic100.N3LongestSubstringWindow;
import leetcode.topic100.N3LongestSubstringWindowOpt;
import net.mindview.atunit.Test;

public class N3Top100Test {

    @org.junit.Test
    public void test1() throws Exception {
        int length = new N3LongestSubstring().lengthOfLongestSubstring("jbpnbwwd");
        System.out.println(length);
    }

    @org.junit.Test
    public void test2() throws Exception {
        int length = new N3LongestSubstringWindow().lengthOfLongestSubstring("jbpnbwwd");
        System.out.println(length);
    }

    @org.junit.Test
    public void test3() throws Exception {
        //"tmmzuxt" "abcabcbb"

        int length = new N3LongestSubstringWindowOpt().lengthOfLongestSubstring("tmmzuxt");
        System.out.println(length);
    }

    @org.junit.Test
    public void test4() throws Exception {
        //"tmmzuxt" "abcabcbb"
         String time="00:16.42";
         String[] res=time.split("[:,\\.]");
         System.out.println(res[0]+" "+res[1]+" "+res[2]);
    }

}
