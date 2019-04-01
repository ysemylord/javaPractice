package leetcode;

public class N125 {
    /***
     * 125. 验证回文串
     * https://leetcode-cn.com/problems/valid-palindrome/
     */

    public boolean isPalindrome(String s) {
        boolean isPalindrome = true;

        int head = 0, tail = s.length() - 1;
        while (true) {

            while (head < s.length() && !isIllegal(s.charAt(head))) {
                head++;
            }
            while (tail >= 0 && !isIllegal(s.charAt(tail))) {
                tail--;
            }

            if (!(head <= tail)) {
                break;
            }

            if (!isEquale(s.charAt(head), s.charAt(tail))) {
                isPalindrome = false;
                break;
            }
            head++;
            tail--;
        }
        System.out.println(s + " is palindrome : " + isPalindrome);
        return isPalindrome;
    }

    private boolean isEquale(char char1, char char2) {
        char1 = changeLowerToUppder(char1);
        char2 = changeLowerToUppder(char2);
        return char1 == char2;
    }

    /**
     * 判断字符是数字或者字母
     * 因为字符 a-z A-Z 0-9 的Ascii码是连续的，
     * 所以可以使用如下方式
     *
     * @param identify
     * @return
     */
    private boolean isIllegal(char identify) {
        return isLetter(identify) || isNumber(identify);
    }

    private boolean isLetter(char identify) {
        return (identify >= 'a' && identify <= 'z') || (identify >= 'A' && identify <= 'Z');
    }

    private boolean isNumber(char identify) {
        return identify >= '0' && identify <= '9';
    }

    //将小写字母转化为大写字符

    /**
     * @param letter 一个字母
     * @return 大写字母
     */
    private char changeLowerToUppder(char letter) {
        if (letter >= 'a' && letter <= 'z') {
            letter = (char) (letter - ('a' - 'A'));
        }
        return letter;
    }
}
