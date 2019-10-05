package cn.edu.ustc.leetcode.intt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
题目：
Given n non-negative integers a1, a2, ..., an ,
where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container,
such that the container contains the most water.

Note: You may not slant the container and n is at least 2.


思路：
使用两个指针low和high，从两头向中间缩小。当low对应的值比high对应的值小时，就low++，否则high--；
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
        int res=0;
        int low=0,high= height.length-1;
        while(low<high){
            res=Math.max(res,Math.min(height[low],height[high])*(high-low));
            if(height[low]<height[high])
                low++;
            else
                high--;
        }
        return res;
    }
}
