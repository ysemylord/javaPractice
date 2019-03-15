package algorithm_m.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 * 技巧：第i个元素向右移k位，则其最终位置为(num+k)%arr.length
 */
public class RotateA {
    public static void main(String[] args) {
        RotateA rotate=new RotateA();
        int[] nums = {1, 2};
        rotate.rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 能够解出，但是时间复杂度为O（n^2）,有待改进
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        System.out.println(Arrays.toString(nums)+"-"+k);
        int start = 0;

        while (start<k) {//外循环，控制移动多少格
            int i = start;
            int temp = nums[start%nums.length];
            int count=0;
            //内部循环，保证移动一格
            while (count++ < nums.length) {
                int dst = (i + 1) % nums.length;
                int t = nums[dst];//记录下dst位置的值
                nums[dst] = temp;//移动i处的值到dst
                temp = t;//记录下dst位置的值
                i++;//右移
            }

            System.out.println(Arrays.toString(nums));
            start++;
        }
    }


}
