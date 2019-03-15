package algorithm_m.leetcode.sevenScale504;

import algorithm_m.fourAdapter.MyStack;

import java.util.LinkedList;

public class Convert {
    public static void main(String[] args) {
        Convert convert = new Convert();
        String res = convert.convertToBase7(100);
        System.out.println(res);
    }


    public String convertToBase7(int num) {
        return convert(num, 7);

    }

    private String convert(int number, int scale) {
        if (number == 0) {
            return "0";
        }

        LinkedList<Character> myStack = new LinkedList<>();
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6',
                '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        int singal = number / Math.abs(number);
        number = Math.abs(number);
        while (number > 0) {
            int yu = number % scale;
            myStack.push(chars[yu]);
            number = number / scale;

        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!myStack.isEmpty()) {
            stringBuilder.append(myStack.pop());
        }
        if (singal == 1) {
            return stringBuilder.toString();
        } else {
            return "-" + stringBuilder.toString();
        }
    }
}
