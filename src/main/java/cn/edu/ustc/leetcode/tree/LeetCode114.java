package cn.edu.ustc.leetcode.tree;
/*
题目：
给定一棵二叉树，将它平铺成一个链表。

思路：


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
public class LeetCode114 {
    public void flatten(TreeNode root) {
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode pre=cur.left;
                while(pre.right!=null)
                    pre=pre.right;

                pre.right=cur.right;
                cur.right=cur.left;

                cur.left=null;
            }
            cur=cur.right;
        }
    }
}
