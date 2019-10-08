package cn.edu.ustc.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
题目：
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
思路：

*/
public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if(i>start&&candidates[i]==candidates[i-1])
                    continue;
                list.add(candidates[i]);
                backtrack(candidates, res, list, remain - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
