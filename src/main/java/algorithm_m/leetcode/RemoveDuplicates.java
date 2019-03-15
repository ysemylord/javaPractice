package algorithm_m.leetcode;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates=new RemoveDuplicates();
        int size=removeDuplicates.removeDuplicates(new int[]{1,1,2,3,3,3,4,5,6,6,122,122});
        System.out.println(size);
    }

    public int removeDuplicates(int[] nums) {
        int size=nums.length,j=1;
        for (int i = 0; i < size-1; ) {
              if(nums[i]==nums[i+1]){
                  removeDuplicate(nums,i+1,size);
                  System.out.println(Arrays.toString(nums));
                  size--;
              }else{
                  i++;
              }
        }
        return size;
    }

    /**
     * 移出数组中的第index个数
     * @param nums
     * @param index 要删除的元素位置
     * @param size 数组中元素规模
     */
    private void removeDuplicate(int[] nums,int index,int size){
        for (int i = index+1; i < size; i++) {
             nums[i-1]=nums[i];
        }
    }

}
