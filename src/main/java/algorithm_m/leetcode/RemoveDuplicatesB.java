package algorithm_m.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesB {

    public static void main(String[] args) {
        RemoveDuplicatesB removeDuplicates=new RemoveDuplicatesB();
        int size=removeDuplicates.removeDuplicates(new int[]{1,1,2,3,3,3,4,5,6,6,122,122});
        System.out.println(size);
    }

    public int removeDuplicates(int[] nums) {
       int j=0,i=0;
       while((++j)< nums.length){
            if(nums[j]!=nums[j-1]){
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }



}
