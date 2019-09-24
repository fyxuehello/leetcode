package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目：
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
思路：
利用求最大子序列和的思想，求最大收益和即为题目要求；
maxCur+=prices[i]-prices[i-1],若二者只差小于零，取0
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int maxCur=0,maxSofar=0;
        for(int i=1;i<prices.length;i++){
            maxCur=Math.max(0,maxCur+=prices[i]-prices[i-1]);
            maxSofar=Math.max(maxCur,maxSofar);
        }
        return maxSofar;
    }
}
