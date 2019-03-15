package algorithm_m.leetcode;

import algorithm_m.Fib.Fib;

public class HashDemo {
    public static void main(String[] args) {

    }
    public int search(int[] elementData,int element,int low,int high){
        Fib fib=new Fib(element);

        int mid=fib.pre();
        while(low<high){
            if(element<elementData[mid]){
                high=mid;
            }else if(elementData[mid]<element){
                low=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
