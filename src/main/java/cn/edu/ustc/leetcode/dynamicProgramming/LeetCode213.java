package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目:
You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed.  All houses at this place are arranged in a circle.
 That means the first house is the neighbor of the last one.
 Meanwhile, adjacent houses have security system connected and it will automatically
 contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.
Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
思路：
动态规划
因为有个房间呈环形，那么共有两种选择：第一种是从第一间到怠速第二间或者从第二间到倒数第一间；
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }
    private int rob(int[] nums,int lo,int hi){
        int prev1=0,prev2=0;
        for(int i=lo;i<=hi;i++){
            int temp=prev1;
            prev1=Math.max(prev2+nums[i],prev1);
            prev2=temp;
        }
        return prev1;
    }
}
