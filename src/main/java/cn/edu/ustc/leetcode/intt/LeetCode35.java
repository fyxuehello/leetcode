package cn.edu.ustc.leetcode.intt;

/*
题目：
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
思路：

 */
public class LeetCode35 {
    //二分查找，找到第一个等于或大于target的位置
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }
}
