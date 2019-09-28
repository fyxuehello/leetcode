package cn.edu.ustc.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
题目:
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
思路：
hashset保存的是互不相等的元素；
 */
public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            HashSet<Character> row=new HashSet<>();
            HashSet<Character> col=new HashSet<>();
            HashSet<Character> cube=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && !row.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !col.add(board[j][i]))
                    return false;

                int rowIndex=3*(i/3);
                int colIndex=3*(i%3);
                if(board[rowIndex+j/3][colIndex+j%3]!='.' && !cube.add(board[rowIndex+j/3][colIndex+j%3]))
                    return  false;
            }
        }
        return true;
    }
}
