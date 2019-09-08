package cn.edu.ustc.leetcode.tree;
/*
题目：
给一颗二叉树，返回其最小深度；

思路：

深度和高度：
深度是从根节点向下（从上往下），根节点的深度为0；
高度是从下往上，最下面的叶子节点是1；

递归思想

第一步：明确方法的作用，给出一个二叉树的节点，找出其最大深度；
第二步：递归出口：root==null,返回0；
第三步：递归传递，传入root的左节点和右节点，然后取最小值；
注意：假若根节点的左子树或右子树为空，则其树的深度为不为空的深度；
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
public class LeetCode111 {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftDepth=minDepth(root.left);
        int rightDepth=minDepth(root.right);

        return (leftDepth==0||rightDepth==0)?leftDepth+rightDepth+1:Math.min(leftDepth,rightDepth)+1;
    }
}
