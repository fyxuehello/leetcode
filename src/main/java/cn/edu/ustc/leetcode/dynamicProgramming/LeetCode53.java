package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目:
给定一个数组，求它的最大子串；
思路：
动态规划
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];//dp[i]表示数组从0~i位置的最大连续子串值
        dp[0]=nums[0];
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            dp[i]=nums[i]+(dp[i-1]>0?dp[i-1]:0);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public int maxSubArray2(int[] nums) {
        int max=nums[0],sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum<0){
                sum=nums[i];
            }else{
                sum+=nums[i];
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}
