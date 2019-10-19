package cn.edu.ustc.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/*
题目：
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
思路：

 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> list=new ArrayList<>();
        dfs(s,0,list,res);
        return res;
    }
    private void dfs(String s,int pos,List<String> list,List<List<String>> res){
        if(pos==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }else{
            for(int i=0;i<s.length();i++){
                if(isPalindrome(s,pos,i)){
                    list.add(s.substring(pos,i+1));
                    dfs(s,i+1,list,res);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    private boolean isPalindrome(String s,int left,int right){
        if(left==right){
            return true;
        }else{
            while(left<right){
                if(s.charAt(left)!=s.charAt(right))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
