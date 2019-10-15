package cn.edu.ustc.leetcode.substring;
/*
题目：
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
思路：

 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        //首先存取t中的每个字符
        int[] map=new int[128];
        for(char c:t.toCharArray()){
            map[c]++;
        }
        int start=0,end=0,minStart=0,minLen=Integer.MAX_VALUE,counter=t.length();
        while(end<s.length()){
            char c1=s.charAt(end);
            if(map[c1]>0)
                counter--;
            map[c1]--;
            end++;
           while(counter==0){
               if(minLen>end-start){
                   minLen=end-start;
                   minStart=start;
               }
               char c2=s.charAt(start);
               map[c2]++;
               if(map[c2]>0)
                   counter++;
               start++;
           }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);
    }
}
