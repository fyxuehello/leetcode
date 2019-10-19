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
    /*
1.Initialize the 'cut' array: For a string with n characters s[0, n-1],
it needs at most n-1 cut. Therefore, the 'cut' array is initialized as cut[i] = i-1
2.Use two variables in two loops to represent a palindrome:
The external loop variable 'i' represents the center of the palindrome.
The internal loop variable 'j' represents the 'radius' of the palindrome.Apparently, j <= i is a must.
This palindrome can then be represented as s[i-j, i+j]. If this string is indeed a palindrome, then one possible value of cut[i+j] is cut[i-j] + 1,
where cut[i-j] corresponds to s[0, i-j-1] and 1 correspond to the palindrome s[i-j, i+j];
     */
    public int minCut2(String s) {
        if(s==null||s.length()<=1)
            return 0;
        int len=s.length();
        int[] dp=new int[len+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=i-1;
        }
        for(int i=0;i<len;i++){
            for(int j=0;i-j>=0&&i+j<len&&s.charAt(i-j)==s.charAt(i+j);j++){
                dp[i+j+1]=Math.min(dp[i+j+1],dp[i-j]+1);
            }
            for(int j=1;i-j+1>=0&&i+j<len&&s.charAt(i-j+1)==s.charAt(i+j);j++){
                dp[i+j+1]=Math.min(dp[i+j+1],dp[i-j+1]+1);
            }
        }
        return dp[len];
    }
}
