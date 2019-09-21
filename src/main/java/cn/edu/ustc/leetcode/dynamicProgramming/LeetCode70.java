package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目：
爬楼梯，每次只能爬一层或者两层，求爬到n层有多少种方法；
思路：
利用动态规划做；


 */
public class LeetCode70 {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
