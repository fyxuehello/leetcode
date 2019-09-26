package cn.edu.ustc.leetcode.dynamicProgramming;

import java.util.Arrays;

/*
题目:
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
思路：
动态规划

 */
public class LeetCode221 {
    public int maximalSquare(char[][] matrix) {
        //空间复杂度O(m*n)，时间复杂度(m*n)
        int m=matrix.length,n=matrix[0].length,size=0;
        int[][] dp=new int[m][n];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0||j==0||matrix[i][j]=='0')
                    dp[i][j]=0;
                else
                   dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                size=Math.max(size,dp[i][j]);
            }
        }
        return size*size;
    }
    public int maximalSquare2(char[][] matrix) {
        //空间复杂度O(n),时间复杂度O(m*n)
        int n=matrix[0].length;
        int[] pre=new int[n+1];
        int[] cur=new int[n+1];
        int res=0;
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1]=='1')
                    cur[j]=Math.min(Math.min(pre[j-1],pre[j]),cur[j-1])+1;
                else
                    cur[j]=0;
                res=Math.max(res,cur[j]);
            }
            pre= Arrays.copyOf(cur,cur.length);
            Arrays.fill(cur,0);
        }
        return res*res;
    }
}
