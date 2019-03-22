package leetcode.topic100;

import java.util.HashMap;
import java.util.Map;

//Two-pass Hash Table
public class TwoSum2 {
    public static void main(String[] args) {
        new TwoSum2().twoSum(new int[]{3, 3}, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> valueToIndex = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            valueToIndex.put(nums[i], i);
        }
        int firsNum;
        int secondNum;
        for (int i = 0; i < nums.length; i++) {
            firsNum = nums[i];
            secondNum = target - firsNum;
            Integer secondIndex = valueToIndex.get(secondNum);
            if (secondIndex != null && secondIndex != i) {
                indices[0] = i;
                indices[1] = secondIndex;
                break;
            }

        }
        System.out.println(indices[0]+"-"+indices[1]);
        return indices;
    }
}
