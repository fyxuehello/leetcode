package cn.edu.ustc.jianzhioffer;


import cn.edu.ustc.leetcode.util.ListNode;

/*
统计一个数字在排序数组中出现的次数。


题目中提到了有序数组，则首先想到用二分查找；
*/

public class Number37 {
    public int GetNumberOfK(int [] array , int k) {
        if(array==null)
            return 0;
        int firstIndex=getFirst(array,k);
        int lastIndex=getLast(array,k);
        if(firstIndex!=-1&&lastIndex!=-1)
            return lastIndex-firstIndex+1;
        return 0;
    }
    private int getFirst(int[] array,int k){
        int low=0,high=array.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(array[mid]<k)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;
    }
    private int getLast(int[] array,int k){
        int low=0,high=array.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(array[mid]<=k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if(high>=0&&array[high]==k)
            return high;
        return -1;
    }

    //

}
