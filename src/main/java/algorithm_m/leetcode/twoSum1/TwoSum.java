package algorithm_m.leetcode.twoSum1;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums =new  int[]{2,5,5,11};
        int  target = 10;
        TwoSum twoSum=new TwoSum();
        int[] res=twoSum.twoSum(nums,target);
        System.out.println(res[0]+":"+res[1]);
    }

    /**
     * 数据结构使用HashMao优化查找过程
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> valutToPos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valutToPos.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer integer = valutToPos.get(diff);

            if (integer != null) {
                if(i==integer){//元素不能重复利用
                    continue;
                }
                res[0] = i;
                res[1] = integer;
                break;
            }
        }
        return res;
    }
}
