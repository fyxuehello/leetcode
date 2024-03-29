package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目:
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from
robbing each of them is that adjacent houses have security system connected and it will
automatically contact the police if two adjacent houses were broken into on the same night.

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
到达当前房间i有两种选择：如果i-2+nums[i]大于i-1
 */
public class LeetCode198 {
    public int rob1(int[] nums) {
        int[] dp=new int[nums.length+1];//dp[i]表示到达第i间房子所得到的最大值
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i+1]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        return dp[nums.length];
    }
    public int rob2(int[] nums){
        if(nums.length==0)
            return 0;
        int prev1=0,prev2=0;//当前数值为i,prev1表示i-2,prev2表示i-1
        for(int i=0;i<nums.length;i++){
            int temp=prev1;
            prev1=Math.max(prev2+nums[i],prev1);
            prev2=temp;
        }
        return prev1;
    }
}
