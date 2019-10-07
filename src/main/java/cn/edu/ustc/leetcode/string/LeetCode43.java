package cn.edu.ustc.leetcode.string;

/*
题目：
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
思路：
模拟两个大数相乘，两个数字只可能是两个数字，对其进行整除可以得到十位，对其取余得到个位。

 */
public class LeetCode43 {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p1 = i + j, p2 = i + j + 1;
                int mutiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = pos[p2] + mutiply;

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer s : pos) {
            if (!(sb.length() == 0 && s == 0))
                sb.append(s);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
