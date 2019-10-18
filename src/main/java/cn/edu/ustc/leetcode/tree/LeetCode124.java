package cn.edu.ustc.leetcode.tree;
/*
题目：

思路：
*/

import cn.edu.ustc.leetcode.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode124 {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        helper(root);
        return maxValue;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxValue = Math.max(maxValue, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
