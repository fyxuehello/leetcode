package cn.edu.ustc.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
题目:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
思路：
暴力解；
hashtable；

 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int temp=target-nums[i];
                if(temp==nums[j])
                    res[0]=i;
                    res[1]=j;
            }
        }
        return res;
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no two such sum");
    }
}
