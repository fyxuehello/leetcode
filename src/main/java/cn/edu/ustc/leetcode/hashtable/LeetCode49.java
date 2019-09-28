package cn.edu.ustc.leetcode.hashtable;

import java.lang.reflect.Array;
import java.util.*;

/*
题目:
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
思路：
hashset保存的是互不相等的元素；
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String st=String.valueOf(c);
            if(map.containsKey(st)) {
                map.put(st, new ArrayList<>());
            }else{
                map.get(st).add(s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
