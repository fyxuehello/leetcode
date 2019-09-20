package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目：
给定两个数m,n,表示m行n列，一个机器人从(1,1)的位置到(m,n)的位置有多少种走法；
机器人只能向下或者向右走；

思路：

利用动态规划思想，dp[i][j]=dp[i-1][j]+dp[i][j-1];
注意边界情况；

 */
public class LeetCode67 {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++)
            dp[i][0]=1;
        for(int j=0;j<n;j++)
            dp[0][j]=1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
