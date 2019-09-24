package cn.edu.ustc.leetcode.dynamicProgramming;

import java.util.List;

/*
题目：
Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
思路：
从底到顶动态规划解题；
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n];//dp[i]表示从底到第i行所需要的最短路径；
        //先储存最后一行的元素
        for(int i=0;i<n;i++){
            dp[i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){//从倒数第二行开始往上
            for(int j=0;j<=i;j++){//到达这一个的每个元素所需要的最短路径
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];//返回从底层到顶层所需要的最短路径
    }
}
