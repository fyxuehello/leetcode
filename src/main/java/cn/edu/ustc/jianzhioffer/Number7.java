package cn.edu.ustc.jianzhioffer;

/*
题目：
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 */
public class Number7 {
    //递归版本,时间复杂度为O(2^n)
    public int Fibonacci1(int n) {
        if (n <= 1)
            return n;
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    //动态规划解法，时间复杂度O(n),空间复杂度为O(n)
    public int Fibonacci2(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //最佳解法,时间复杂度O(n)，空间复杂度(n)
    public int Fibonacci3(int n) {
        if (n <= 1)
            return n;
        int preNum = 1;
        int prepreNum = 0;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = preNum + prepreNum;
            prepreNum = preNum;
            preNum = res;
        }
        return res;
    }
}
