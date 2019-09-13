package cn.edu.ustc.leetcode.tree;
/*
题目：输出二叉查找树中第k个小的元素

思路：
二叉查找树的中序遍历是有序的；

 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(--k==0){
                return root.val;
            }
            root=root.right;
        }
        return -1;
    }
}


