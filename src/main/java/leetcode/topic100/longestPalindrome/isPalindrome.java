package leetcode.topic100.longestPalindrome;

/**
 * 检验一个字符串是不是回文
 */
public class isPalindrome {

    /**
     * 从中间向两边扩散
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s) {
        boolean isPalindrome = true;
        int length = s.length();
        int middle = length / 2;
        int left, right;
        if (length % 2 == 0) {//长度为偶数
            left = middle - 1;
            right = middle;
        } else {
            left = middle - 1;
            right = middle + 1;
        }

        while (left >= 0 && right < length) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left--;
            right++;
        }
        System.out.println(s + " is palindrome : " + isPalindrome);
        return isPalindrome;
    }

    /**
     * 从两边向里面靠拢
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome2(String s) {
        boolean isPalindrome = true;

        int head = 0, tail = s.length() - 1;
        while (head <= tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                isPalindrome = false;
                break;
            }
            head++;
            tail--;
        }
        System.out.println(s + " is palindrome : " + isPalindrome);
        return isPalindrome;
    }




}
