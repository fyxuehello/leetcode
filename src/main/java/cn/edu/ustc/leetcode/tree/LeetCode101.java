package cn.edu.ustc.leetcode.tree;
/*
题目：
判断一个树是否成镜像；

思路：
递归判断一个节点的子节点的左子树和另一个节点的右子树是否相等。
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
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return root==null||isSymmetric(root.left,root.right);
    }
    private boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null||right==null)
            return left==right;

        if(left.val!=right.val)
            return false;

        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }
}
