package cn.edu.ustc.leetcode.intt;

/*
题目：
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
思路：

 */
public class LeetCode42 {
    public int trap(int[] height) {
        if (height.length < 3)
            return 0;
        int left = 0, right = height.length - 1, totalArea = 0;
        int maxLeft = height[left], maxRight = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[++left]);
                totalArea +=(maxLeft-height[left]);
            }else{
                maxRight=Math.max(maxRight,height[--right]);
                totalArea+=(maxRight-height[right]);
            }
        }
        return totalArea;
    }
}
