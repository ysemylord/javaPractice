package leetcode.topic100;

import java.util.HashMap;
import java.util.Map;

//one-pass Hash Table
public class TwoSum3 {
    public static void main(String[] args) {
        new TwoSum3().twoSum(new int[]{3, 3}, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        int firstNum;
        int secondNum;

        Map<Integer, Integer> valueToIndex = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            firstNum=nums[i];
            secondNum=target-firstNum;
            Integer secondIndex=valueToIndex.get(secondNum);
            if(secondIndex!=null&&secondIndex!=i){
                indices[0]=secondIndex;
                indices[1]=i;
                break;
            }
            valueToIndex.put(nums[i], i);
        }
        return indices;
    }
}
