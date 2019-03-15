package algorithm_m;


public class HailstoneSequence {
    public static void main(String[] args) {
        System.out.println(hailStoneCount(64));
    }

    /**
     * 计算
     * 对于n得到的HailStone的个数
     * @param n
     * @return
     */
    private static int hailStoneCount(int n){
           int length=1;
           while(n>1){
              boolean evenNumber=n%2==0?true:false;
              if(evenNumber){
                  n=n/2;
              }else{
                  n=n*3+1;
              }
              length++;
           }
           return length;
    }
}
