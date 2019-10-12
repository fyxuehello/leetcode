package cn.edu.ustc.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
题目：
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that
no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
思路：
N皇后问题，采用回溯算法；
*/
public class LeetCode51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> res=new ArrayList<>();
        dfs(res,board,0);
        return res;
    }
    private void dfs(List<List<String>> res,char[][] board,int colIndex){
        if(colIndex==board.length){
            res.add(builder(board));
            return;
        }
        for(int i=0;i<board.length;i++){
            if(validate(board,i,colIndex)){
                board[i][colIndex]='Q';
                dfs(res,board,colIndex+1);
                board[i][colIndex]='.';
            }
        }
    }
    private boolean validate(char[][] board,int x,int y){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]=='Q'&&(x+j==y+i||x+y==i+j)||x==i){
                    return false;
                }
            }
        }
        return true;
    }
    private List<String> builder(char[][] board){
        List<String> res=new LinkedList<>();
        for(int i=0;i<board.length;i++){
            String  s=new String(board[i]);
            res.add(s);
        }
        return res;
    }
}

