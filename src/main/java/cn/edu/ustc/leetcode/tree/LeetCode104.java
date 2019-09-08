package cn.edu.ustc.leetcode.tree;
/*
题目：
给一颗二叉树，返回其最大深度；
Example:
Given binary tree [3,9,20,null,null,15,7],return its depth = 3.
思路：
递归思想

第一步：明确方法的作用，给出一个二叉树的节点，找出其最大深度；
第二步：递归出口：root==null,返回0；
第三步：递归传递，传入root的左节点和右节点，然后取最大值；
 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }
}
