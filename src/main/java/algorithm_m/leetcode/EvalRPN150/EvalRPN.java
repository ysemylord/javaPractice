package algorithm_m.leetcode.EvalRPN150;


import algorithm_m.leetcode.Stack;

public class EvalRPN {
    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        int res = evalRPN.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(res);
    }

    /**
     * tokens为RPN表达式
     * 如
     * 1 2 + 3 * 表现为 ["1","2","+","*"]
     *12 2 + 3 * 表现为 ["12","2","+","*"]
     * @param tokens 逆波兰表达式
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (!isOptr(str)) {//如果是数字，直接入栈
                stack.push(Integer.parseInt(str));
            } else {
                int rightNum = stack.pop();
                int leftNum = stack.pop();
                int res = operator(str, leftNum, rightNum);
                stack.push(res);
            }
        }
        return stack.peek();
    }

    /**
     * 是否是操作符
     * RPN是没有括号的
     *
     * @return
     */
    private boolean isOptr(String str) {
        switch (str) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
        }
        return false;
    }

    private int operator(String optStr, int lefNum, int rightNum) {
        switch (optStr) {
            case "+":
                return lefNum + rightNum;
            case "-":
                return lefNum - rightNum;
            case "*":
                return lefNum * rightNum;
            case "/":
                return lefNum / rightNum;
        }
        return -1;
    }
}
