package cn.edu.ustc.leetcode.sort;

import java.util.Arrays;

/*
题目：
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"

思路：
将数组转化为字符串数组，然后将其排序，按照前后两个字符串两两组合哪个的数字大就放在前面。

 */
public class LeetCode179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        String[] s_nums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_nums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s_nums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (s_nums[0].charAt(0) == '0')
            return "0";
        StringBuilder res = new StringBuilder();
        for (String s : s_nums) {
            res.append(s);
        }
        return res.toString();
    }
}
