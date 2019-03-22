package leetcode.topic100;

//Brute Force
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        int[] indices=new int[2];
        int firstNum;
        int secondNum;
        for (int i = 0; i < nums.length; i++) {
             firstNum=nums[i];
            for (int j = i+1; j <nums.length ; j++) {
                 secondNum=nums[j];
                if((firstNum+secondNum)==target){
                    indices[0]=i;
                    indices[1]=j;
                    break;
                }
            }
        }
        return indices;
    }
}
