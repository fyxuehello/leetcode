package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目：
给定一个字符串，返回其最长回文子串；
思路：
使用动态规划解题；当我们想到用动态规划解题时，第一个问题就是它的子问题是什么？如何把原问题和子问题连接起来；

我们使用一个二维数组dp来表示(i,j)是否回文串，如果是的话就为true，否则为false；

 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if(s==null||s.length()<2)
            return s;

        String res=null;
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                dp[i][j]=s.charAt(i)==s.charAt(j)&&(j-i<3||dp[i+1][j-1]);

                if(dp[i][j]&&(res==null||j-i+1>res.length()))
                    res=s.substring(i,j+1);
            }
        }
        return res;
    }
}
