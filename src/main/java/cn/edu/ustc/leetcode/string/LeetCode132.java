package cn.edu.ustc.leetcode.string;

/*
题目：
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
思路：

 */
public class LeetCode132 {
    public int minCut(String s) {
        if(s==null||s.length()<=1)
            return 0;
        int len=s.length();
        int[] dp=new int[len+1];
        for(int i=0;i<dp.length;i++){//初始化dp[]
            dp[i]=i;
        }
        for(int mid=1;mid<len;mid++){
            //字符个数为奇数的情况
            for(int start=mid,end=mid;start>=0&&end<len&&s.charAt(start)==s.charAt(end);start--,end++){
                int newCut=start==0?0:dp[start-1]+1;
                dp[end]=Math.min(dp[end],newCut);
            }
            //字符个数为偶数的情况
            for(int start=mid-1,end=mid;start>=0&&end<len&&s.charAt(start)==s.charAt(end);start--,end++){
                int newCut=start==0?0:dp[start-1]+1;
                dp[end]=Math.min(dp[end],newCut);
            }
        }
        return dp[len-1];
    }
}
