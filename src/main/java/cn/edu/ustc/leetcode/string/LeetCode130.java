package cn.edu.ustc.leetcode.string;

/*
题目：
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
思路：
把矩阵的四条边上是'O‘以及它的相邻为O的变换成*，然后把中间的O全部变成X,最后再把*替换成O即可
 */
public class LeetCode130 {
    public void solve(char[][] board) {
        if(board.length<=1||board[0].length<=1)
            return;
        int row=board.length;
        int col=board[0].length;
        //检查第一列和最后一列
        for(int i=0;i<row;i++){
            if(board[i][0]=='O')
                dfs(board,i,0);
            if(board[i][col-1]=='O')
                dfs(board,i,col-1);
        }
        //检查第一行和最后一行
        for(int j=0;j<col;j++){
            if(board[0][j]=='O')
                dfs(board,0,j);
            if(board[row-1][j]=='O')
                dfs(board,row-1,j);
        }
        //替换
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='*')
                    board[i][j]='*';
            }
        }
    }
    private void dfs(char[][] board,int i,int j){
        if(i<0||i>board.length-1||j<0||j>board[0].length)
            return;
        if(board[i][j]=='O')
            board[i][j]='*';
        if(i>1&&board[i+1][j]=='O')
            dfs(board,i+1,j);
        if(i<board.length-2&&board[i-1][j]=='O')
            dfs(board,i-1,j);
        if(j>1&&board[i][j+1]=='O')
            dfs(board,i,j+1);
        if(j<board[0].length-2&&board[i][j-1]=='O')
            dfs(board,i,j-1);

    }
}
