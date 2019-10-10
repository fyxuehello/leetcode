package cn.edu.ustc.leetcode.string;

import java.util.Stack;

/*
题目：
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

思路：

 */
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                   res=Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }
    public int longestValidParentheses2(String s) {
        int[] dp=new int[s.length()];//表示到第i个位置最长的有效括号
        int open=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                open++;
            if(s.charAt(i)==')'&&open>0){
                dp[i]=2+dp[i-1];
                if(i-dp[i]>0){
                    dp[i]+=dp[i-dp[i]];
                }
                open--;
            }
            if(max<dp[i])
                max=dp[i];
        }
        return max;
    }
}
