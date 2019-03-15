package algorithm_m.leetcode;

/**
 * 插值查找 num35
 */
public class SearchInsertImpr {


    /**
     * 简单的方法，先列出特殊情况，然后跌点一般情况
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int i = binarySearchC(nums, target, 0, nums.length);
        return i;
    }

    public int binarySearchC(int elementData[],int element,int low,int high){
        while(high>low){//
            int mid=(low+high)/2;
            if(element<elementData[mid]){
                high=mid;
            }else {
                low=mid+1;
            }
            System.out.println("mid:"+mid);
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInsertImpr searchInsert=new SearchInsertImpr();
       int res= searchInsert.binarySearchC(new int[]{1,3,5,6},5,0,4);
        System.out.println(res);

    }
}
