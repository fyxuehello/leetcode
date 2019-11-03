package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目:给定一个字符串，返回最大子串的值；

思路：
动态规划
 */
public class LeetCode {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];//dp[i]表示以nums[i]结尾的子串的最大值
        dp[0]=nums[0];
        int max=dp[0];

        for (int i=1;i<n;i++){
            dp[i]=nums[i]+(dp[i-1]>0?dp[i-1]:0);

            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
