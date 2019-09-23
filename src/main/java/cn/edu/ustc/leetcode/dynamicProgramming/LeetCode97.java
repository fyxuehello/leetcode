package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目：
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

思路：
看到字符串子串问题或者字符串匹配问题，首先考虑用动态规划做；
dp[i][j]表示字符串s1的前i个字符和s2的前j个字符是否能交织组成s3的前i+j个字符。
 */
public class LeetCode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(),n=s2.length(),l=s3.length();
        if(m+n!=l)
            return false;
        boolean[][] dp=new boolean[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0&&j==0)
                    return dp[i][j]=true;
                else if(i==0)
                    dp[i][j]=(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
                else if(j==0)
                    dp[i][j]=(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1));
                else{
                    dp[i][j]=(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
                }
            }
        }
        return dp[m][n];
    }
}

