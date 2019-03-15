package algorithm_m.leetcode.ParenMatch20;

import algorithm_m.fourAdapter.MyStack;

import java.util.LinkedList;

/**
 * 括号匹配
 */
public class ParenMatch {

    public static void main(String[] args) {
        ParenMatch parenMatch = new ParenMatch();
        System.out.println(parenMatch.isValid("]{}()"));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        return paren(chars, 0, chars.length);
    }

    public boolean paren(char[] chars, int low, int high) {
        LinkedList<Character> myStack = new LinkedList<>();
        while (low < high) {
            if (isLeftParen(chars[low])) {//遇见左括号，右括号入栈
                myStack.push(chars[low]);
                System.out.println("入栈");
            } else {//遇见右括号
                if (myStack.isEmpty()) {//如果栈为空，表示没有与右括号匹配的左括号
                    System.out.println("为空");
                    return false;
                } else {
                    char left = myStack.pop();
                    if (!match(left, chars[low])) {
                        return false;
                    }
                    System.out.println("出栈");
                }
            }
            low++;
        }

        //字符数组遍历完成后，如果栈不为空，则说明没有与左括号对应的右括号
        return myStack.isEmpty() ? true : false;
    }

    private boolean isLeftParen(char paren) {
        if (paren == '(' || paren == '[' || paren == '{') {
            return true;
        }
        return false;
    }

    private boolean match(char leftChar, char rightChar) {
        switch (leftChar) {
            case '(':
                return rightChar == ')' ? true : false;
            case '[':
                return rightChar == ']' ? true : false;
            case '{':
                return rightChar == '}' ? true : false;

        }
        return false;
    }
}
