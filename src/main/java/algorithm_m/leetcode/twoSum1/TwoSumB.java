package algorithm_m.leetcode.twoSum1;

import java.util.HashMap;

public class TwoSumB {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 5, 11};
        int target = 10;
        TwoSumB twoSum = new TwoSumB();
        int[] res = twoSum.twoSum(nums, target);
        System.out.println(res[0] + ":" + res[1]);
    }

    /**
     * 数据结构使用HashMao优化查找过程
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> valutToPos = new HashMap<>();
        for (int positino = 0; positino < nums.length; positino++) {
            //放入之前先查找
            int diff = target - nums[positino];
            Integer integer = valutToPos.get(diff);
            if (integer != null) {
                res[0] = integer;
                res[1] = positino;
                break;
            }
            valutToPos.put(nums[positino], positino);
        }
        return res;
    }
}
