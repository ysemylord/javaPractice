package algorithm_m.fourAdapter;

/**
 * 进制转化
 * 逆序输出
 */
public class Convert {
    public static void main(String[] args) {
        MyStack<Character> stack=convert(16,16);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    /**
     * 进制转化
     * 要点有3
     * 1. 短除法进行进制转化
     * 2. 计算结果的映射
     * 3. 结果的存储
     * @param number 要被转化的数
     * @param scale  转化成的进制
     * @return
     */
    private static MyStack<Character> convert(int number, int scale) {
        MyStack<Character> myStack = new MyStack<>();
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6',
                '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        while (number> 0) {
            int yu = number % scale;
            myStack.push(chars[yu]);
            number = number / scale;

        }
        return myStack;
    }
}
