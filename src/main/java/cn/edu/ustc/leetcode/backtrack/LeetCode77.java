package cn.edu.ustc.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
题目：
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
思路：

*/
public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        help(res,new ArrayList<Integer>(),1,n,k);
        return res;
    }
    private void help(List<List<Integer>> res,List<Integer> list,int start,int n,int k){
        if(k==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=start;i<=n;i++){
            list.add(i);
            help(res,list,i+1,n,k-1);
            list.remove(list.size()-1);
        }
    }
}
