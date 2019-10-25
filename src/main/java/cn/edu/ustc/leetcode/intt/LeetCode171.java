package cn.edu.ustc.leetcode.intt;

/*
题目：
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701

思路：
*/
public class LeetCode171 {
    public int titleToNumber(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            int temp=s.charAt(i)-'A'+1;
            res=res*26+temp;
        }
        return res;
    }
}
