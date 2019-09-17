package cn.edu.ustc.leetcode.sort;

import java.util.Arrays;

/*
题目：
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
思路：
我们可以把每个字符串排序进行比较，此法比较简答。

另外，我们用一个新的数组存取二十六个字母出现的次数，
第一个字符串每个字母出现一次就加一，第二个字符串每个字母出现一次就减一。判断最后数组中是否全是零，如果是的话，
则返回true，否则返回false；

 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        int[]  num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }
        for(int j=0;j<t.length();j++){
            num[t.charAt(j)-'a']--;
        }

        for(int i:num){
            if(i!=0)
                return false;
        }
        return true;
    }
}
