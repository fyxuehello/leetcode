package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目：
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
思路：

仍旧使用动态规划解题，相比于上一题，本题增加了一个判断。

 */
public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width=obstacleGrid[0].length;
        int[] dp=new int[width];

        dp[0]=1;
        for(int[] row:obstacleGrid){
            for(int i=0;i<width;i++){
                if(row[i]==1)
                    dp[i]=0;
                else if(i>0){
                    dp[i]+=dp[i-1];
                }
            }
        }
        return dp[width-1];
    }
}
