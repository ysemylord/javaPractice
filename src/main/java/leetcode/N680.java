package leetcode;

public class N680 {

    class Result {
        boolean isPalindrome;
        int start;
        int end;

        public Result(boolean isPalindrome, int start, int end) {
            this.isPalindrome = isPalindrome;
            this.start = start;
            this.end = end;
        }
    }

    private Result isPalindrome(String s, int leftEdge, int rightEdge) {
        boolean isPalindrome = true;

        int head = leftEdge, tail = rightEdge;
        while (head <= tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                isPalindrome = false;
                break;
            }
            head++;
            tail--;
        }
        return new Result(isPalindrome, head, tail);
    }

    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        boolean isPalindrome = true;
        Result res = isPalindrome(s, start, end);
        boolean leftIsPalindrome;
        boolean rightIsPalindrome;
        if (!res.isPalindrome) {
            leftIsPalindrome = isPalindrome(s, res.start + 1, res.end).isPalindrome;
            rightIsPalindrome = isPalindrome(s, res.start, res.end - 1).isPalindrome;
            isPalindrome = leftIsPalindrome || rightIsPalindrome;
        }
        return isPalindrome;
    }

}
