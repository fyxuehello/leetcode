package cn.edu.ustc.leetcode.dynamicProgramming;
/*
题目:
给定一个整数数组nums，在具有最大乘积的数组（包含至少一个数字）中找到连续的子数组。

思路：
动态规划
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int res=nums[0];
        int imax=res,imin=res;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){//如果当前数字小于零，那么乘以最大值变成最小的，乘以最小值 变成最大的；故，交换最大值最小值
                int temp=imax;
                imax=imin;
                imin=temp;
            }
            imax=Math.max(nums[i],imax*nums[i]);
            imin=Math.min(nums[i],imin*nums[i]);

            res=Math.max(res,imax);
        }
        return res;
    }
}
