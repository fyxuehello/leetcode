package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目：
给定两个字符串，求将字符串1转化为字符串2所需要操作的最小次数；
思路：
利用动态规划做；
定义二维数组，dp[i][j]表示将字符串Word[0,i)转化为字符串Word[0,j)所需的最小操作数；
 dp[i][0] = i and dp[0][j] = j.

 我们把dp[i][j]转化为子问题,假设dp[i-1][j-1]已经知道，假如Word1[i-1]==Word2[j-1],
 那么dp[i][j]=dp[i-1][j-1];
 假如不相等的话，则分为三种情况：
1.Replace word1[i - 1] by word2[j - 1] (dp[i][j] = dp[i - 1][j - 1] + 1);
2.If word1[0..i - 1) = word2[0..j) then delete word1[i - 1] (dp[i][j] = dp[i - 1][j] + 1);
3.If word1[0..i) + word2[j - 1] = word2[0..j) then insert word2[j - 1] to word1[0..i) (dp[i][j] = dp[i][j - 1] + 1).
 */
public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
