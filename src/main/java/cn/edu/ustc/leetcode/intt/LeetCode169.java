package cn.edu.ustc.leetcode.intt;

/*
题目：
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
思路：
*/
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        int majority=nums[0],count=1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                count++;
                majority=nums[i];
            }else if(majority==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return majority;
    }
}
