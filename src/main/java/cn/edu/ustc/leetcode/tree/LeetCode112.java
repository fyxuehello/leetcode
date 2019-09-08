package cn.edu.ustc.leetcode.tree;
/*
题目：
给定一个二叉树和一个值，判断二叉树的所有路径里是否等于这个值；

思路：
递归思想，注意边界条件的判定。

 */

import cn.edu.ustc.leetcode.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.left==null&&root.right==null&&sum-root.val==0)
            return false;

        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
