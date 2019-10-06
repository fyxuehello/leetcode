package cn.edu.ustc.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
题目：
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
思路：
和上一题不同的是，本题带有重复数字。首先排序，再用一个数组used表示当前数字是否被用过。
回溯法也是一种深度优先遍历，只要满足情况下，会一直往前，当遇到不满足的条件时会返回。
*/
public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,new ArrayList<Integer>(),nums,new boolean[nums.length]);
        return res;
    }
    private void backtrack(List<List<Integer>> res,ArrayList<Integer>list,int[] nums,boolean[] used){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
        }
        for(int i=0;i<nums.length;i++){
            if(used[i-1]||(i>0&&nums[i]==nums[i-1]&&!used[i-1]))
                continue;
            used[i]=true;
            list.add(nums[i]);
            backtrack(res,list,nums,used);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}

