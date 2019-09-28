package cn.edu.ustc.leetcode.hashtable;

import java.util.*;

/*
题目:
iven a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
思路：使用异或操作符来解答
对于两个相等的数字进行异或对结果没有影响，而且异或具有可交换性。
2^2^3^3^4^4^5=5;

 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
        }
        return res;
    }
}
