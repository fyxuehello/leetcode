package cn.edu.ustc.leetcode.tree;
/*
题目：
给定一个二叉树和一个值，判断二叉树的所有路径里是否等于这个值并返回该路径；

思路：
利用回溯法寻找路径，一旦不满足条件就返回；
递归思想，注意边界条件的判定。

 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        pathSum(root,sum,cur,res);
        return res;
    }
    private void pathSum(TreeNode root,int sum,List<Integer> cur,List<List<Integer>> res){
        if(root==null)
            return;
        cur.add(root.val);

        if(root.left==null&&root.right==null&&root.val==sum){
            res.add(new ArrayList<Integer>(cur));
        }else{
            pathSum(root.left,sum-root.val,cur,res);
            pathSum(root.right,sum-root.val,cur,res);
        }
        cur.remove(cur.size()-1);//回溯
    }

}
