package cn.edu.ustc.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/*
题目：
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
思路：

 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res=new ArrayList<>();
        if(res.isEmpty())
            return res;
        res.add("");
        for(char c:digits.toCharArray()){
            res=combine(map[c-'0'],res);
        }
        return res;
    }
    private List<String> combine(String digits,List<String> list){
        List<String> res=new ArrayList<>();
        for(char c:digits.toCharArray()){
            for(String s:list){
                res.add(s+c);
            }
        }
        return res;
    }
}
