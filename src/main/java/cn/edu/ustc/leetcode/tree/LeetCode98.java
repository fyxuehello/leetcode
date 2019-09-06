package cn.edu.ustc.leetcode.tree;
/*
题目：
判断给定的一个树是否是二叉查找树；

思路：
迭代法：中序遍历一个二叉查找树的结果是递增的，
我们可以遍历每一个节点然后将其值与上一个节点的值比较，如果小于或等于则返回false。
递归法：
首先，明确方法的作用；
其次，给出递归出口；
最后，找打递归的关系式。
 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode98 {
    //迭代法
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root,pre=null;

        while(cur!=null||!stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if(pre!=null&&cur.val<=pre.val)
                return false;
            pre=cur;
            cur=cur.right;
        }
        return true;
    }
    //递归法
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isValidBST2(TreeNode root,long min,long max){
        if(root==null)
            return true;
        if(root.val<=min||root.val>=max)
            return false;
        return isValidBST2(root.left,min,root.val)&&isValidBST2(root.right,root.val,max);
    }
}
