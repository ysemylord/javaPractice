package algorithm_m.fourAdapter;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(new Permutation().isPermutation(new int[]{1,2,3},new int[]{3,1,2}));
    }

    /**
     * 判断序列arrB是否是序列arrA混洗的结果
     * @param arrA
     * @param arrB
     * @return
     */
    public boolean isPermutation(int[] arrA, int[] arrB) {
        MyStack<Integer> stackA = new MyStack<>();
        MyStack<Integer> stackB = new MyStack<>();
        MyStack<Integer> stackS = new MyStack<>();
        for (int i = arrA.length - 1; i >= 0; i--) {
            stackA.push(arrA[i]);
        }
        for (int i = arrB.length - 1; i >= 0; i--) {
            stackB.push(arrB[i]);
        }

        while (true) {
            if (stackS.isEmpty() || !stackB.top().equals(stackS.top())) {
                if(stackA.isEmpty()){//A中没有待选元素
                    return false;
                }
                stackS.push(stackA.pop());
                System.out.println("入栈");
            } else {
                System.out.println("出栈");
                stackS.pop();
                stackB.pop();
            }

            if(stackB.isEmpty()){//B中的元素匹配完成了
                return true;
            }
        }

    }
}
