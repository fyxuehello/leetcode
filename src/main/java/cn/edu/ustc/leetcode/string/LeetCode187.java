package cn.edu.ustc.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
题目：
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
思路：

 */
public class LeetCode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> store=new HashSet<>();
        Set<String> res=new HashSet<>();
        for(int i=0;i+9<s.length();i++){
            if(!store.add(s.substring(i,i+10))){
                res.add(s.substring(i,i+10));
            }
        }
        return new ArrayList<>(res);
    }
}
