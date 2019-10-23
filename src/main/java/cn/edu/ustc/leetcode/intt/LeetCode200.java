package cn.edu.ustc.leetcode.intt;

/*
题目：
Given a 2d grid map of '1's (land) and '0's (water),
count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

思路：
 */
public class LeetCode200 {
    int row,col;
    public int numIslands(char[][] grid) {
        int count=0;
        row=grid.length;
        if(row==0)
            return 0;
        col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int i,int j){
        if(i<0||j<0||i>=row||j>=col||grid[i][j]!='1')
            return;
        grid[i][j]='2';//标记已经访问过的

        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
