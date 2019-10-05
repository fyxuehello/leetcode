package cn.edu.ustc.leetcode.intt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
题目：
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
思路：

 */
public class LeetCode50 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        double res = myPow(x, n / 2);
        return x % 2 == 0 ? res * res : n < 0 ? res * res * (1 / x) : res * res * x;
    }

}
