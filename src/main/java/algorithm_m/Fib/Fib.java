package algorithm_m.Fib;

/**
 * 斐波拉契数列项
 *
 * 函数定义
 * 1.构造时传入一个num,得到一个不小于num的最小Fib数列
 * 如
 * [0,1,1,2,3,5,8，13]
 * Fib（6）
 * Fib.g==8；
 *
 * Fib（7）
 * Fib.g==8；
 *
 * Fib（8）
 * Fib.g==8；
 *
 * 2. Fib.get()获取当前fib项
 *
 * 3.Fib.next(）获取后一个Fib项
 *
 * 4.Fib.pre() 获取前一个Fib项
 *
 *
 */
public class Fib {
    int g=0,f=1;
    public Fib(int num){//初始化为不小于num的最小Fibonacci项
        while(g<num) {
           next();
        }
    }

    public int get(){
        return g;
    }

    /**
     *
     * @return 后一项
     */
    public  int next(){
        g = g + f;
        f = g - f;
        return g;
    }

    /**
     * 前一项
     * @return
     */
    public  int pre(){
        f=g-f;
        g=g-f;
        return g;
    }

    public static void main(String[] args) {
        Fib fib=new Fib(10);
        System.out.println(fib.get());
    }

}
