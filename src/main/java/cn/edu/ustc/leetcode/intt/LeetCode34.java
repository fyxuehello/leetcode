package cn.edu.ustc.leetcode.intt;

/*
题目：
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

思路：

 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int first=firstIndex(nums,target);
        if(first==nums.length||nums[first]!=target)
            return new int[]{-1,-1};
        return new int[]{first,firstIndex(nums,target+1)-1};
    }
    private int firstIndex(int[] nums,int target){//第一个等于大于target的位置
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=high-(high-low)/2;
            if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;
    }
}
