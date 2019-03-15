package leetcode;

import net.mindview.util.RandomGenerator;

import java.util.ArrayList;

//https://leetcode-cn.com/problems/add-digits/
public class N258 {
    public static void main(String[] args) {
        System.out.println(new N258().addDigits3(38));
    }

    /**
     * 思路
     * 1.取出num中的每一位
     * 2.做求和
     * 3.根据结果进行不同操作
     */

    /**
     * 耗时和addDigits2一样
     * @param num
     * @return
     */
    public int addDigits3(int num) {

        int size=0;
        int copyNum=num;

        while(copyNum>0){
            copyNum=copyNum/10;
            size++;
        }

        int nums[]=new int [size];
        int index=0;
        while(num>0){
            nums[index]=(num%10);
            num=num/10;
            index++;
        }

        int sum=0;
        for (int i = 0; i < size; i++) {
            sum=sum+nums[i];
        }
        if(sum>=10){
            return addDigits(sum);
        }else{
            return sum;
        }
    }


    /**
     * 9 ms
     * 超多4.6%
     * @param num
     * @return
     */
    public int addDigits(int num) {
        String string = String.valueOf(num);
        char[] nums = string.toCharArray();
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum=sum+Integer.parseInt(nums[i]+"");
        }
        if(sum>=10){
             return addDigits(sum);
        }else{
            return sum;
        }
    }

    public int addDigits4(int num) {
        String string = String.valueOf(num);
        char[] nums = string.toCharArray();
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum=sum+(nums[i]-'0');
        }
        if(sum>=10){
            return addDigits(sum);
        }else{
            return sum;
        }
    }

    /**
     * 2ms 超过80
     * @param num
     * @return
     */
    public int addDigits2(int num) {
        ArrayList<Integer> nums=new ArrayList<>();

        while(num>0){
            nums.add(num%10);
            num=num/10;
        }

        int sum=0;
        for (int i = 0; i < nums.size(); i++) {
            sum=sum+nums.get(i);
        }

        if(sum>=10){
            return addDigits(sum);
        }else{
            return sum;
        }
    }



}
