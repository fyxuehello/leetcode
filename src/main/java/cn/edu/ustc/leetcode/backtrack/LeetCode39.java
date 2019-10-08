package cn.edu.ustc.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
题目：
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
思路：

*/
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }

    private void backtrack(int[] candidates, List<List<Integer>> res, ArrayList<Integer> list, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            res.add(new ArrayList<Integer>(list));
        else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtrack(candidates, res, list, remain - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
