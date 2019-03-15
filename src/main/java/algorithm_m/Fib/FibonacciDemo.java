package algorithm_m.Fib;

public class FibonacciDemo {


    public static void main(String[] args) {
        System.out.println(iteration(4));
        System.out.println(recursion(4));
    }

    /**
     * 查找fib数列的第n个数fib(n)
     * 递归
     * @param n
     * @return
     */
    private static int recursion(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        return recursion(n-1)+recursion(n-2);
    }

    /**
     * 查找fib数列的第n个数fib(n)
     * 迭代
     * @param n
     * @return
     */
    private static int iteration(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }

        int f=0,g=1,tempG;

        while((n--)>=2){//迭代的次数比n少二

            //算法的规律
            tempG=g;
            g=g+f;
            f=tempG;
        }
        return g;
    }

}
