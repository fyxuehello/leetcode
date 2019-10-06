package cn.edu.ustc.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
题目：
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
思路：
回溯法也是一种深度优先遍历，只要满足情况下，会一直往前，当遇到不满足的条件时会返回。
*/
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> res=new ArrayList<>();
       backtrack(res,new ArrayList<>(),nums);
       return res;
    }
    private void backtrack(List<List<Integer>> res,ArrayList<Integer> list,int[] nums){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            backtrack(res,list,nums);
            list.remove(list.size()-1);//that means remove the element u just added on the back,
            // u can also call it backtrack
        }
    }
}
