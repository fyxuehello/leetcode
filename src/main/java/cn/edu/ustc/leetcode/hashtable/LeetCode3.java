package cn.edu.ustc.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/*
题目:
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
思路：
用一个hashmap储存字符串的字符及其所对应的的索引。

 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int res=0;
        for(int left=0,right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                left=Math.max(left,s.charAt(right)+1);
            }else{
                map.put(s.charAt(right),right);
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}
