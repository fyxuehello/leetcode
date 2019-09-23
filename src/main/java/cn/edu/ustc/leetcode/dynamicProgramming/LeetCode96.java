package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目：
给一个数字 n ,BST的各节点由(1,n)组成，求能形成多少个不重复的BST。
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
思路：
利用动态规划做，定义一个数组G[n]表示（1，n）能形成BST的数目。
F(i,n)表示以i为root，可以形成BST的数目；

G[n]=F(1,n)+F(2,n)+F(3,n)+...

F(i,n)=G(i-1)*G(n-i);

从而，G[n]=G[0]*G[n]+G[1][n-1]+G[2][n-2]...
 */
public class LeetCode96 {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;//表示空节点和一个节点能形成BST的个数；

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}

