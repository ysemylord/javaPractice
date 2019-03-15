package algorithm_m.leetcode;

/**
 * 插值查找 num35
 */
public class SearchInsert {


    /**
     * 简单的方法，先列出特殊情况，然后跌点一般情况
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int index = -1;
        if(target<=nums[0]){
            return 0;
        }else if(nums[nums.length-1]==target){
            return nums.length-1;
        }else if(nums[nums.length-1]<target){
            return nums.length;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==target){
                return i;
            }
            if(nums[i]<target&&nums[i+1]>target){
                return i+1;
            }
        }
        return index;

    }

    public static void main(String[] args) {
        SearchInsert searchInsert=new SearchInsert();
        //searchInsert
    }
}
