package cn.edu.ustc.leetcode.intt;

/*
题目：
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
思路：

 */
public class LeetCode123 {
    public int maxProfit(int[] prices) {
        //dynamic programming
        //f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
        //         = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
        int n=prices.length;
        if(n<=1)
            return 0;
        int[][] dp=new int[3][n];//dp[i][j] meanrepresents the max profit up until prices[j] using at most i transactions.
        int maxPro=0;
        for(int i=1;i<=2;i++){
            int tempMax=dp[i-1][0]-prices[0];
            for(int j=1;j<n;j++){
                dp[i][j]=Math.max(dp[i][j-1],tempMax+prices[j]);
                tempMax=Math.max(tempMax,dp[i-1][j]-prices[j]);
                maxPro=Math.max(maxPro,dp[i][j]);
            }
        }
        return maxPro;
    }
}
