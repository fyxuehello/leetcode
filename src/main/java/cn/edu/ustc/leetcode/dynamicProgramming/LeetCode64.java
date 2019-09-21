package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目：
给定一个二维数组，求其从左上角到右下角的最小和路径和；
思路：
利用动态规划做；


 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid.length;

        int[][] sum=new int[row][col];
        sum[0][0]=grid[0][0];
        for(int i=1;i<row;i++){
            sum[i][0]=sum[i-1][0]+grid[i][0];
        }
        for(int i=1;i<col;i++){
            sum[i][0]=sum[i-1][0]+grid[i][0];
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                sum[i][j]=Math.min(sum[i-1][j],sum[i][j-1])+grid[i][j];
            }
        }
        return sum[row-1][col-1];
    }
}
