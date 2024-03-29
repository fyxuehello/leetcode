package cn.edu.ustc.leetcode.intt;

/*
题目：
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
思路：
利用贪心算法
 */
public class LeetCode45 {
    public int jump(int[] nums) {
      int  jumps=0,curEnd=0,curFasted=0;
      for(int i=0;i<nums.length-1;i++){
          curFasted=Math.max(curFasted,i+nums[i]);
          if(i==curEnd){
              jumps++;
              curEnd=curFasted;
          }
      }
      return jumps;
    }
}
