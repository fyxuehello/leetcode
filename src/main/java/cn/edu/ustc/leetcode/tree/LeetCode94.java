package cn.edu.ustc.leetcode.tree;
/*
题目：
给定一个二叉树，中序遍历每一个节点，并将值输出；

思路：
题目要求不能使用递归，迭代遍历的话我们可以利用一个栈来模拟递归。
 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
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
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }
}
